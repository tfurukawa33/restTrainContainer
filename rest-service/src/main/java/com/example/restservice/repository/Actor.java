package com.example.restservice.repository;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="actor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "actor_id", unique = true, nullable = false, updatable = false)
    private int id;

    @Column(name = "first_name", nullable = false)
    @NotNull
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotNull
    private String lastName;

    @OneToMany
    @JoinTable(
        name = "film_actor",
        joinColumns = {
            @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "film_id", referencedColumnName = "film_id", unique = true)
        }
    )
    @JsonIgnoreProperties("actors")
    private List<Film> films;

}
