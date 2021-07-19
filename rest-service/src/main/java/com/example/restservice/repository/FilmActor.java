package com.example.restservice.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "file_actor")
public class FilmActor {
    @Id
    @Column(name = "actor_id", nullable = false, updatable = true)
    @NotNull
    private int actorId;

    @Column(name = "file_id", nullable = false, updatable = true)
    @NotNull
    private int fileId;
}
