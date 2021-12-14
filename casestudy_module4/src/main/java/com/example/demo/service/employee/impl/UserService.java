package com.example.demo.service.employee.impl;

import com.example.demo.model.employee.User;
import com.example.demo.repository.employee.IUserRepository;
import com.example.demo.service.employee.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;


    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Integer id) {
        userRepository.deleteById(id);
    }
}
