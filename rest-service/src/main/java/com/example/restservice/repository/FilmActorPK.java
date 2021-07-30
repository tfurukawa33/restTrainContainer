package com.example.restservice.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FilmActorPK implements Serializable {
    @Column(name = "film_id", nullable = false)
    private int filmId;

    @Column(name = "actor_id", nullable = false)
    private int actorId;
}