package com.example.restservice.service;

import java.util.List;
import java.util.Optional;

import com.example.restservice.repository.Actor;
import com.example.restservice.repository.ActorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;
    
    public Page<Actor> findAll(Pageable pageable) {
        return actorRepository.findAll(pageable);
    }

    public Optional<Actor> findById(int id) {
        return actorRepository.findById(id);
    }

    public List<Actor> findByFirstName(String name) {
        return actorRepository.findByFirstNameLike(name);
    }
}
