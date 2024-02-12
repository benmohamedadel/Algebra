package com.example.demo.repository;

import com.example.demo.model.HelloEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends JpaRepository<HelloEntity, Long> {
    // You can add custom query methods if needed
}
