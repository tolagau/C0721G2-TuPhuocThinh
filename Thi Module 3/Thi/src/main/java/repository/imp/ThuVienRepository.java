package repository.imp;

import bean.HocSinh;
import bean.MatBang;
import bean.MuonSach;
import bean.Sach;
import util.ConnectionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThuVienRepository {
    private static ConnectionSQL connectionSQL = new ConnectionSQL();

    public void insertMuonSach(MuonSach muonSach) {
        try {
            PreparedStatement preparedStatement = connectionSQL.getConnection().prepareStatement
//                    ("insert into customer(customer_type_id,customer_name, birthday, gender,id_card,phone,email,address)" +
//                            " values(?,?,?,?,?,?,?,?)");
        ("insert into muon_sach(muon_sach_ma,sach_ma,hoc_sinh_ma,muon_sach_ngay_muon,muon_sach_ngay_tra) values\n" +
                "(?,?,?,?,?);");
            preparedStatement.setString(1, muonSach.getId());
            preparedStatement.setString(2, muonSach.getSach().getName());
            preparedStatement.setString(3, muonSach.getHocSinh().getName());
            preparedStatement.setString(4, muonSach.getCheckIn());
            preparedStatement.setString(5, muonSach.getCheckOut());
            preparedStatement.executeUpdate();
            // System.out.println(land.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionSQL.close();
        }
    }

    public static List<MuonSach> selectAll() {

        List<MuonSach> muonSachArrayList = new ArrayList<>();
        Connection connectionSQL = new ConnectionSQL().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connectionSQL.prepareStatement("select muon_sach_ma, sach_ma, hoc_sinh_ma, muon_sach_ngay_muon, muon_sach_ngay_tra\n" +
                    "from muon_sach;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("muon_sach_ma");

                String idSach = resultSet.getString("sach_ma");

                String idHocSinh = resultSet.getString("hoc_sinh_ma");
                String checkIn = resultSet.getString("muon_sach_ngay_muon");
                String checkOut = resultSet.getString("muon_sach_ngay_tra");
//                String nameSach = resultSet.getString("sach_ten");
//                String nameHocSinh = resultSet.getString("hoc_sinh_ten");
                muonSachArrayList.add(new MuonSach(id, new Sach(idSach), new HocSinh(idHocSinh), checkIn, checkOut));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionSQL.close();
        }
        return muonSachArrayList;
    }


}
