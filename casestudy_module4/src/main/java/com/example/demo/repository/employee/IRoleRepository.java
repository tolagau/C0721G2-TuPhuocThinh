package com.example.demo.repository.employee;

import com.example.demo.model.employee.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
