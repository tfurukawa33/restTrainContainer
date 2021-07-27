package com.example.restservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ActorRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ActorRepository actorRepository;

    @BeforeEach
    private void beforeEach() {
        entityManager.persist(Actor.builder().id(1).firstName("Alice").lastName("Alice").build());
        entityManager.persist(Actor.builder().id(2).firstName("Bob").lastName("Bob").build());
        entityManager.persist(Actor.builder().id(3).firstName("Charlie").lastName("Charlie").build());
    }

    @Test
    public void testExample() throws Exception {
        Optional<Actor> actor = actorRepository.findById(2);
        assertEquals(Actor.builder().id(2).firstName("Bob").lastName("Bob").build(), actor);
    }
}
