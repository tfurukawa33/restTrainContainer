package com.example.restservice.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="actor")
public class Actor {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "actor_id", unique = true, nullable = false, updatable = false)
    private int id;

    @Column(name = "first_name", nullable = false)
    @NotNull
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotNull
    private String lastName;
}
