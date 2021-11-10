package repository.imp;

import bean.LoaiMatBang;
import bean.MatBang;
import repository.IMatBang;
import util.ConnectionSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepository implements IMatBang {
    private static ConnectionSQL connectionSQL = new ConnectionSQL();

    @Override
    public List<MatBang> selectAll() {
        List<MatBang> matBangList = new ArrayList<>();
        try {
            Statement statement = connectionSQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from mat_bang;");
            MatBang matBang = null;
            LoaiMatBang loaiMatBang = null;
            while (resultSet.next()) {
                matBang = new MatBang();
                loaiMatBang = new LoaiMatBang();
                loaiMatBang.setId(String.valueOf(resultSet.getInt("loai_mat_bang_id")));
                matBang.setId(String.valueOf(resultSet.getInt("mat_bang_id")));
                matBang.setDienTich(resultSet.getString("mat_bang_area"));
                matBang.setTrangThai(resultSet.getString("mat_bang_trang_thai"));
                matBang.setTang(resultSet.getString("mat_bang_floor"));
                matBang.setLoaiMatBang(loaiMatBang);
                matBang.setMoTa(resultSet.getString("mat_bang_mo_ta"));
                matBang.setGia(resultSet.getString("mat_bang_gia"));
                matBang.setNgayDB(resultSet.getString("mat_bang_ngay_bd"));
                matBang.setNgayKT(resultSet.getString("mat_bang_ngay_kt"));
                matBangList.add(matBang);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connectionSQL.close();
        }
        return matBangList;
    }

    @Override
    public MatBang selectLand(String id) {
        return null;
    }

    @Override
    public void insertLand(MatBang land) {
        try {
            PreparedStatement preparedStatement = connectionSQL.getConnection().prepareStatement
//                    ("insert into customer(customer_type_id,customer_name, birthday, gender,id_card,phone,email,address)" +
//                            " values(?,?,?,?,?,?,?,?)");
        ("insert into mat_bang values(?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1, land.getId());
            preparedStatement.setString(2, String.valueOf(Integer.parseInt(land.getDienTich())));
            preparedStatement.setString(3, land.getTrangThai());
            preparedStatement.setString(4, String.valueOf(Integer.parseInt(land.getTang())));
            preparedStatement.setString(5, String.valueOf(Integer.parseInt(land.getLoaiMatBang().getId())));
            preparedStatement.setString(6, land.getMoTa());
            preparedStatement.setString(7, land.getGia());
            preparedStatement.setString(8, land.getNgayDB());
            preparedStatement.setString(9, land.getNgayKT());
            preparedStatement.executeUpdate();
            // System.out.println(land.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionSQL.close();
        }
    }

    @Override
    public void updateLand(MatBang land) {

    }

    @Override
    public void deleteLand(String id) {
        try {
            PreparedStatement preparedStatement = connectionSQL.getConnection().prepareStatement("delete  from mat_bang where mat_bang_id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connectionSQL.close();
        }
    }

    @Override
    public List<MatBang> searchLand(String loaiMatBang, int gia, int tang) {
        List<MatBang> landList = new ArrayList<>();
        try {
            PreparedStatement ps = connectionSQL.getConnection().prepareStatement
                    ("select land_id,l.land_status_id,ls.land_status_name,area,floor,l.land_type_id,lt.land_type_name,\n" +
                            "price,checkin,checkout\n" +
                            " from land l\n" +
                            " join land_type lt on lt.land_type_id = l.land_type_id\n" +
                            " where (lt.land_type_name like concat('%',?,'%')) \n" +
                            " and (price = ?) \n" +
                            " and (floor = ?);");
            ps.setString(1, loaiMatBang);
            ps.setInt(2, gia);
            ps.setInt(3, tang);
            ResultSet resultSet = ps.executeQuery();
            MatBang matBang = null;
            LoaiMatBang loai = null;
            while (resultSet.next()) {

                loai = new LoaiMatBang();
                matBang = new MatBang();

                loai.setId(String.valueOf(resultSet.getInt("land_type_id")));

                loai.setName(resultSet.getString("land_type_name"));


                matBang.setId(resultSet.getString("land_id"));

                matBang.setTrangThai("trangthai");

                matBang.setDienTich(String.valueOf(resultSet.getInt("area")));

                matBang.setTang(String.valueOf(resultSet.getInt("floor")));

                matBang.setLoaiMatBang(loai);

                matBang.setGia(String.valueOf(resultSet.getInt("price")));

                matBang.setNgayDB(resultSet.getString("checkin"));

                matBang.setNgayKT(resultSet.getString("checkout"));

                landList.add(matBang);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return landList;
    }

    @Override
    public List<MatBang> searchLandField(String loaiMatBang, String gia, String tang) {
        return null;
    }
}
