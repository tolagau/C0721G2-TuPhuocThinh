package com.example.demo.service.customer;

import com.example.demo.dto.CustomerUseServiceDTO;
import com.example.demo.model.customer.Customer;
import com.example.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> searchByName(String name, Pageable pageable);

    Page<CustomerUseServiceDTO> listCustomerUsingService(Pageable pageable);

    Optional<Customer> findById(String id);

    void remove(String id);
}
