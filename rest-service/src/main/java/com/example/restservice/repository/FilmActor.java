package com.example.restservice.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "film_actor")
@IdClass(FilmActorPK.class)
public class FilmActor {
    @Id
    @Column(name = "actor_id", nullable = false)
    @NotNull
    private int actorId;

    @Id
    @Column(name = "film_id", nullable = false)
    @NotNull
    private int filmId;
}
