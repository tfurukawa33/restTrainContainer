package com.example.restservice.repository;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "language")
public class Lang {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "language_id", nullable = false, updatable = false)
    @NotNull
    private int id;

    @Column(name = "name", nullable = false, updatable = true)
    @NotNull
    private String name;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(
        name="film",
        joinColumns=@JoinColumn(name="language_id")
    )
    @MapKeyColumn(name="map_key")
    @Column(name="map_value")
    private Map<String, String> map;
}
