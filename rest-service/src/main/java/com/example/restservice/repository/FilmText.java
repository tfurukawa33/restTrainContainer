package com.example.restservice.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "film_text")
@Data
public class FilmText {
    @Id
    @Column(name = "film_id", nullable = false)
    private int filmId;

    @Column(name = "title", nullable = false, updatable = true)
    private String title;

    @Column(name = "description", nullable = true, updatable = true)
    private String description;
}
