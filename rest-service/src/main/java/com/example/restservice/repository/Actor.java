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

import lombok.Data;

@Entity
@Table(name="actor")
@Data
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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "actor_id", insertable = false, updatable = false)
    private Set<FilmActor> filmActors;
}
