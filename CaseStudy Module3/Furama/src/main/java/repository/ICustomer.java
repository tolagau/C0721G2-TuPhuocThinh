package repository;

import bean.customer.Customer;

import java.util.List;

public interface ICustomer {
    public List< Customer > selectAllCustomer();

    public Customer selectCustomer(int id);

    public void insertCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(int id);

    public List< Customer > searchCustomer(String customerName);

}
