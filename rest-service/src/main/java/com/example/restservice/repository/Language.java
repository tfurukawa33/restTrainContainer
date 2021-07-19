package com.example.restservice.repository;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
    private int id;

    @Column(name = "name", nullable = false, updatable = true)
    @NotNull
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "language_id")
    private Set<Film> films;
}
