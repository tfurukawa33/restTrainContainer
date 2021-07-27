package com.example.restservice.controller;

import java.util.Optional;

import com.example.restservice.repository.Film;
import com.example.restservice.service.FilmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(path = "/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping(path = "/all")
    @ResponseBody
    public Page<Film> getAllFilms(@PageableDefault(
        page = 0,
        size = 20,
        direction = Direction.ASC,
        sort = { "id" }  
    ) Pageable pageable) {
        return filmService.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Optional<Film> getActorById(@PathVariable("id") int id) {
        return filmService.findById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Film updateFilm(@PathVariable("id") int id, @Validated @RequestBody Film film) {
        film.setId(id);
        return filmService.save(film);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Film createFilm(@Validated @RequestBody Film film) {
        return filmService.save(film);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteFilm(@PathVariable("id") int id) {
        filmService.delete(id);
    }
}
