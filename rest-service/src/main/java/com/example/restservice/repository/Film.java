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
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title", nullable = false)
    @NotNull
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year", length = 4)
    private int releaseYear;

    @Column(name = "rental_duration", nullable = false)
    @NotNull
    private int rentalDuration;

    @Column(name = "rental_rate", nullable = false)
    @NotNull
    private int rentalRate;

    @Column(name = "length")
    private int length;

    @Column(name = "replacement_cost", columnDefinition = "decimal(5,2) default 19.99", nullable = false)
    @NotNull
    private int replacementCost;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    private Set<FilmActor> filmActors;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    private Set<FilmCategory> filmCategories;
}
