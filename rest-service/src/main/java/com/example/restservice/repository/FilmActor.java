package com.example.restservice.repository;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "film_actor")
@IdClass(FilmActorPK.class)
@Data
public class FilmActor {
    @Id
    @Column(name = "actor_id", nullable = false)
    @NotNull
    private int actorId;

    @Id
    @Column(name = "film_id", nullable = false)
    @NotNull
    private int filmId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "actor_id", insertable = false, updatable = false)
    // @JsonBackReference
    // @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    // @JsonIdentityReference(alwaysAsId = true)
    private Actor actor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    // @JsonBackReference
    // @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    // @JsonIdentityReference(alwaysAsId = true)
    private Film film;
}
