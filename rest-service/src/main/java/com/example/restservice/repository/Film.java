package com.example.restservice.repository;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.EnumType;
// import javax.persistence.Enumerated;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "film")
@Data
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "film_id", unique = true, nullable = false, updatable = false)
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

    // @Column(name = "rating")
    // @Enumerated(EnumType.STRING)
    // private RatingEnum rating;

    @OneToMany
    @JoinTable(
        name = "film_actor",
        joinColumns = {
            @JoinColumn(name = "film_id", referencedColumnName = "film_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "actor_id", referencedColumnName = "actor_id", unique = true)
        }
    )
    @JsonIgnoreProperties("films")
    private List<Actor> actors;

    @OneToMany
    @JoinTable(
        name = "film_category",
        joinColumns = {
            @JoinColumn(name = "film_id", referencedColumnName = "film_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "category_id", referencedColumnName = "category_id", unique = true)
        }
    )
    @JsonIgnoreProperties("filmCategories")
    private Set<Category> categories;
}
