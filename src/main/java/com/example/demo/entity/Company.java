package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name = "company")
public class Company implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = Food.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Food> foods;
}
