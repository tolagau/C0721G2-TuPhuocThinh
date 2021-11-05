package repository.impl;

import bean.customer.Customer;
import bean.customer.CustomerType;
import repository.BaseRepository;
import repository.ICustomer;
import util.GetinfoCustomerTypeSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerRepository implements ICustomer {

    private GetinfoCustomerTypeSQL getinfoCustomerTypeSQL = new GetinfoCustomerTypeSQL();
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try {
            Statement statement = baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customer;");
            Customer customer = null;
            CustomerType customerType = null;
            while (resultSet.next()) {
                for (CustomerType customerType1 : getinfoCustomerTypeSQL.selectAll()) {
                    if (customerType1.getId() == resultSet.getInt("customer_type_id")) {
                        customerType = customerType1;
                    }
                }
                customer = new Customer();
                customer.setId(resultSet.getInt("customer_id"));
                customer.setCustomerType(customerType);
                customer.setName(resultSet.getString("customer_name"));
                customer.setBirthday(resultSet.getString("customer_birthday"));
                customer.setGender(resultSet.getString("customer_gender"));
                customer.setIdCard(resultSet.getString("customer_id_card"));
                customer.setPhoneNum(resultSet.getString("customer_phone"));
                customer.setEmail(resultSet.getString("customer_email"));
                customer.setAddress(resultSet.getString("customer_address"));
                customerList.add(customer);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            baseRepository.close();
        }

        return customerList;
    }

    @Override
    public Customer selectCustomer(int id) {

        List<Customer> customerList = selectAllCustomer();

        Customer customer = null;

        for (Customer customer1 : customerList) {
            if (customer1.getId() == id) {
                customer = customer1;
            }
        }

        return customer;


    }

    @Override
    public void insertCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    ("insert into employee values(?,?,?,?,?,?,?,?");
            preparedStatement.setString(1, String.valueOf(customer.getCustomerType().getId()));
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setString(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhoneNum());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.executeLargeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    ("update customer set `customer_type_id` = ?,customer_name= ?, birthday=? " +
                            " gender=?,id_card=?, email=?, address=? phone=? where customer_id = ?;");
            preparedStatement.setString(1, String.valueOf(customer.getCustomerType().getId()));
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setString(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhoneNum());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.setInt(9, customer.getId());
            preparedStatement.executeLargeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
    }

    @Override
    public void deleteCustomer(int id) {
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    ("delete from customer where customer_id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
    }

    @Override
    public List<Customer> searchCustomer(String customerName) {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement ps = baseRepository.getConnection().prepareStatement("select * from customer where customer_name = ?;");
            ps.setString(1, customerName);
            ResultSet resultSet = ps.executeQuery();
            Customer customer = null;
            CustomerType customerType = null;
            while (resultSet.next()) {
                for (CustomerType customerType1 : getinfoCustomerTypeSQL.selectAll()) {
                    if (customerType1.getId() == resultSet.getInt("customer_type_id")) {
                        customerType = customerType1;
                    }
                }
                customer = new Customer();
                customer.setId(resultSet.getInt("customer_id"));
                customer.setCustomerType(customerType);
                customer.setName(resultSet.getString("customer_name"));
                customer.setBirthday(resultSet.getString("customer_birthday"));
                customer.setGender(resultSet.getString("customer_gender"));
                customer.setIdCard(resultSet.getString("customer_id_card"));
                customer.setPhoneNum(resultSet.getString("customer_phone"));
                customer.setEmail(resultSet.getString("customer_email"));
                customer.setAddress(resultSet.getString("customer_address"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
        return customerList;
    }
}
