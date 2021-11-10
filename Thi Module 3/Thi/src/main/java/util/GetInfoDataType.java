package util;

import bean.HocSinh;
import bean.LoaiMatBang;
import bean.Sach;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetInfoDataType {
    private static ConnectionSQL connectionSQL = new ConnectionSQL();

    public static List<LoaiMatBang> selectLoai() {
        List<LoaiMatBang> loaiMatBangList = new ArrayList<>();
        try {
            Statement statement = connectionSQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from loai_mat_bang ;");
            LoaiMatBang loaiMatBang = null;
            while (resultSet.next()) {
                loaiMatBang = new LoaiMatBang();
                loaiMatBang.setId(String.valueOf(resultSet.getInt("loai_mat_bang_id")));
                loaiMatBang.setName(resultSet.getString("loai_mat_bang_name"));
                loaiMatBangList.add(loaiMatBang);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connectionSQL.close();
        }
        return loaiMatBangList;
    }

    public List<HocSinh> selectHocSinh() {
        List<HocSinh> hocSinhList = new ArrayList<>();
        try {
            Statement statement = connectionSQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from hoc_sinh;");
            HocSinh hocSinh = null;
            while (resultSet.next()) {
                hocSinh = new HocSinh();
                hocSinh.setId(String.valueOf(resultSet.getInt("hoc_sinh_ma")));
                hocSinh.setName(resultSet.getString("hoc_sinh_ten"));
                hocSinh.setLop(resultSet.getString("hoc_sinh_lop"));
                hocSinhList.add(hocSinh);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connectionSQL.close();
        }
        return hocSinhList;
    }


    public List<Sach> selectSach() {
        List<Sach> sachList = new ArrayList<>();
        try {
            Statement statement = connectionSQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from sach;");
            Sach sach = null;
            while (resultSet.next()) {
                sach = new Sach();
                sach.setId(String.valueOf(resultSet.getInt("sach_ma")));
                sach.setName(resultSet.getString("sach_ten"));
                sach.setTacGia(resultSet.getString("sach_tac_gia"));
                sach.setMoTa(resultSet.getString("sach_mo_ta"));
                sach.setSoLuong(Integer.parseInt(resultSet.getString("sach_so_luong")));
                sachList.add(sach);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connectionSQL.close();
        }

        return sachList;
    }

}
