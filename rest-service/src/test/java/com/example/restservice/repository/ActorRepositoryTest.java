package com.example.restservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = { "spring.datasource.url=jdbc:mysql://db_test/sakila_test" })
public class ActorRepositoryTest {

    @Autowired
    private ActorRepository actorRepository;

    // @Test
    @Sql("classpath:META-INF/sql/createActor.sql")
    void testExample() throws Exception {
        Actor actor2 = Actor.builder().id(2).firstName("Bob").lastName("Bob").build();

        Optional<Actor> actor = actorRepository.findById(2);
        Actor actorResult = actor.get();
        assertEquals(actor2, actorResult);
    }
}
