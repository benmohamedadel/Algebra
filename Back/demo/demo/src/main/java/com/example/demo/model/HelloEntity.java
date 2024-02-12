package com.example.demo.model;


import jakarta.persistence.*;

@Entity
public class HelloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String helloValue;

    // Constructors, getters, setters, and other methods

    public HelloEntity() {
        // Default constructor
    }

    public HelloEntity(String helloValue) {
        this.helloValue = helloValue;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHelloValue() {
        return helloValue;
    }

    public void setHelloValue(String helloValue) {
        this.helloValue = helloValue;
    }
}
