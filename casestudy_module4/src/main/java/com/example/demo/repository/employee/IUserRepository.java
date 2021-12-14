package com.example.demo.repository.employee;

import com.example.demo.model.employee.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
