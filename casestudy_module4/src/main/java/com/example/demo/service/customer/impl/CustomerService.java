package com.example.demo.service.customer.impl;

import com.example.demo.dto.CustomerUseServiceDTO;
import com.example.demo.model.customer.Customer;
import com.example.demo.repository.customer.ICustomerRepository;
import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void remove(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> searchByName(String name, Pageable pageable) {
        return customerRepository.searchByName(name, pageable);
    }

    @Override
    public Page<CustomerUseServiceDTO> listCustomerUsingService(Pageable pageable) {
        return customerRepository.listCustomerUsingService(pageable);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void remove(Integer id) {

    }
}
