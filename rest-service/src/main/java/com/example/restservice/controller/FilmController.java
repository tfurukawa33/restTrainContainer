package com.example.restservice.controller;

import java.util.Optional;

import com.example.restservice.repository.Film;
import com.example.restservice.service.FilmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<Film> getAllFilms() {
        return filmService.findAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Optional<Film> getActorById(@PathVariable("id") int id) {
        return filmService.findById(id);
    }
}
