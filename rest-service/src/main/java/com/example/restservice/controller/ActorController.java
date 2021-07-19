package com.example.restservice.controller;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.example.restservice.repository.Film;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api")
public class ActorController {
  @GetMapping(path="/films")
  public @ResponseBody Iterator<Film> getAllSuppliers() {
    List<Film> list = Collections.emptyList();

    Iterator<Film> film = list.iterator();
    return film;
  }
}