package com.example.restservice.repository;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class EmbeddableActor {
    @Column(name="alpha")
    private String value;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="actor_id")
    private FilmActor fileActor;
}
