package com.example.restservice.service;

import com.example.restservice.repository.Film;
import com.example.restservice.repository.FilmRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public Iterable<Film> findAll() {
        return filmRepository.findAll();
    }
}
