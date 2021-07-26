package com.example.restservice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Integer> {
    Page<Actor> findAll(Pageable pageable);

    List<Actor> findByFirstNameLike(String name);
}
