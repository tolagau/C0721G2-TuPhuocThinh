package services;

import models.Customer;

import java.util.List;

public interface Promotion{
    void display();
    List<Customer> presentVoucher();
}
