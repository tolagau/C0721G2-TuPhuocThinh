package com.example.demo.repository.service;

import com.example.demo.model.service.RentalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentalTypeRepository extends JpaRepository<RentalType, Integer> {
}
