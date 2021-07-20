package com.example.restservice.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "film_category")
@IdClass(FilmCategoryPK.class)
@Data
public class FilmCategory {
    @Id
    @Column(name = "film_id", nullable = false)
    @NotNull
    private int filmId;

    @Id
    @Column(name = "category_id", nullable = false)
    @NotNull
    private int CategoryId;
}
