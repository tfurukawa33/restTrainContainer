package com.example.restservice.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "file")
public class Film {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
}
