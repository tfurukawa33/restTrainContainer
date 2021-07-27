package com.example.restservice.controller;

import java.util.List;
import java.util.Optional;

import com.example.restservice.repository.Actor;
import com.example.restservice.service.ActorService;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(path = "/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping(path = "/all")
    @ResponseBody
    public Page<Actor> getAllActors(
        @PageableDefault(
            page = 0,
            size = 20,
            direction = Direction.DESC,
            sort = { "id" }
        ) Pageable pageable
    ) {
        return actorService.findAll(pageable);
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

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Actor updateActor(@PathVariable("id") int id, @Validated @RequestBody Actor actor) {
        actor.setId(id);
        return actorService.save(actor);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Actor createActor(@Validated @RequestBody Actor actor) {
        return actorService.save(actor);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteActor(@PathVariable("id") int id) {
        actorService.delete(id);
    }
}