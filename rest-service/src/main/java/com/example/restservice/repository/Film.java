package com.example.restservice.repository;

import java.time.Year;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.EnumType;
// import javax.persistence.Enumerated;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "film")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "release_year")
    private Year releaseYear;

    @Column(name = "rental_duration", nullable = false)
    @NotNull
    private int rentalDuration;

    @Column(name = "rental_rate", nullable = false)
    @NotNull
    private int rentalRate;

    @Column(name = "length")
    private Integer length;

    @Column(name = "replacement_cost", columnDefinition = "decimal(5,2) default 19.99", nullable = false)
    @NotNull
    private int replacementCost;

    // @Column(name = "rating")
    // @Enumerated(EnumType.STRING)
    // private RatingEnum rating;

    @OneToMany(mappedBy = "film")
    @JsonIgnoreProperties("filmActor.film")
    private Set<FilmActor> filmActor;
}
