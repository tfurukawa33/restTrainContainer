package com.example.restservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Integer> {
    List<Actor> findByFirstNameLike(String name);
}
