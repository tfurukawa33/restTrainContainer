package com.example.restservice.service;

import java.util.Optional;

import com.example.restservice.repository.Film;
import com.example.restservice.repository.FilmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public Iterable<Film> findAll() {
        return filmRepository.findAll();
    }

    public Optional<Film> findById(int id) {
        return filmRepository.findById(id);
    }
}
