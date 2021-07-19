package com.example.restservice.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "file_text")
public class FilmText {
    @Column(name = "film_id", nullable = false, updatable = true)
    private int filmId;

    @Column(name = "title", nullable = false, updatable = true)
    private String title;

    @Column(name = "description", nullable = true, updatable = true)
    private String description;
}
