package com.example.demo.service.employee;

import com.example.demo.model.employee.Employee;
import com.example.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IEmployeeService extends IGeneralService<Employee> {

    Page<Employee> findAll(Pageable pageable);

    List<Employee> search( String keywork);
}
