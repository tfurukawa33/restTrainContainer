package com.example.restservice.service;

import com.example.restservice.repository.Actor;
import com.example.restservice.repository.ActorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;
    
    public Iterable<Actor> findAll() {
        return actorRepository.findAll();
    }
}
