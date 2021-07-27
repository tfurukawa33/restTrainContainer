package com.example.restservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.example.restservice.repository.Actor;

@SpringBootTest
@EnableWebMvc
public class ActorControllerTest {
    
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @BeforeEach
    void beforeEach() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    public Actor getActorOfActorId1() {
        return Actor.builder().id(1).firstName("Alice").lastName("Alice").build();
    }

    public List<Actor> getActorsOfActors() {
        List<Actor> actors = new ArrayList<>();
        Actor actor1 = Actor.builder().id(1).firstName("Alice").lastName("Alice").build();
        Actor actor2 = Actor.builder().id(2).firstName("Bob").lastName("Bob").build();

        actors.add(actor1);
        actors.add(actor2);
        return actors;
    }

    @Test
    void HttpStatusが200であること() throws Exception {
        mockMvc.perform(get("/actor/1"))
            .andExpect(status().isOk());
    }
}
