package com.example.demo.repository.employee;

import com.example.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    Page<Employee> findAll(Pageable pageable);

    @Query(value = "select * from employee " +
            "where " +
            "match (name, address, email) " +
            "AGAINST(:keywork)", nativeQuery = true)
    List<Employee> searchEmployee(@Param("keywork") String keywork);
}
