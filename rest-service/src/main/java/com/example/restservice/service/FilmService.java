package com.example.restservice.service;

import java.util.Optional;

import com.example.restservice.repository.Film;
import com.example.restservice.repository.FilmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public Page<Film> findAll(Pageable pageable) {
        return filmRepository.findAll(pageable);
    }

    public Optional<Film> findById(int id) {
        return filmRepository.findById(id);
    }
}
