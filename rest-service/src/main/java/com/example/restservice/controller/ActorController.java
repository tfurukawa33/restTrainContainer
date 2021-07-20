package com.example.restservice.controller;

import java.util.List;
import java.util.Optional;

import com.example.restservice.repository.Actor;
import com.example.restservice.service.ActorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/actor")
public class ActorController {

  @Autowired
  private ActorService actorService;

  @GetMapping(path = "/all")
  @ResponseBody
  public Iterable<Actor> getAllActors() {
    return actorService.findAll();
  }

  @GetMapping(path = "/{id}")
  @ResponseBody
  public Optional<Actor> getActorById(@PathVariable("id") int id) {
    return actorService.findById(id);
  }

  @GetMapping(path = "/")
  @ResponseBody
  public List<Actor> getActorByName(@RequestParam(value = "name") String name) {
    List<Actor> actors = actorService.findByFirstName(name);
    return actors;
  }
}