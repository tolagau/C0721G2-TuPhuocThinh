package util;

import bean.customer.CustomerType;
import repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetinfoCustomerTypeSQL {
   private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL = "select * from customer_type";

    public  List<CustomerType> selectAll() {

        List<CustomerType> customerTypeList = new ArrayList<>();
        try{
            Statement statement = baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customer_type;");
            CustomerType customerType = null;
            while (resultSet.next()){
                customerType = new CustomerType();
                customerType.setId(resultSet.getInt("customer_type_id"));
                customerType.setName(resultSet.getString("customer_type_name"));
                customerTypeList.add(customerType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }
}
