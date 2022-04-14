package com.example.demo.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "food")
public class Food implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Company company;

    @OneToMany(targetEntity = Sale.class, mappedBy = "id", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Sale> sales;
}
