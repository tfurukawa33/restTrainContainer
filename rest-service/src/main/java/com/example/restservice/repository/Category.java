package com.example.restservice.repository;

import java.util.List;
// import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

// import com.example.restservice.filter.FilmCategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", unique = true, nullable = false, updatable = false)
    private int id;

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    // @OneToMany(fetch = FetchType.EAGER)
    // @JoinColumn(name = "category_id", insertable = false, updatable = false)
    // private Set<FilmCategory> filmCategories;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "film_category",
        joinColumns = {
            @JoinColumn(name = "category_id", referencedColumnName = "category_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "film_id", referencedColumnName = "film_id", unique = true)
        }
    )
    @JsonIgnoreProperties("categories")
    private List<Film> films;
}
