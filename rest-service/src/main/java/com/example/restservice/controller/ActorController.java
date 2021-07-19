package com.example.restservice.controller;

// import java.util.Iterator;

import com.example.restservice.repository.Actor;
import com.example.restservice.service.ActorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api")
public class ActorController {

  @Autowired
  private ActorService actorService;

  @GetMapping(path="/actors")
  public @ResponseBody Iterable<Actor> getAllActors() {
    return actorService.findAll();
  }
  // public @ResponseBody Iterator<Actor> getAllActors() {
  //   Iterator<Actor> actors = actorService.findAll().iterator();
  //   return actors;
  // }
}