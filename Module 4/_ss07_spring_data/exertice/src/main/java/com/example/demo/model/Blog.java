package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String topic;

    private String author;

    @ManyToOne(targetEntity = ECommerce.class)
    private ECommerce eCommerce;

    public Blog() {
    }

}
