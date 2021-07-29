SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO actor
    (actor_id, first_name, last_name)
VALUES
    (1, "Alice", "Alice"),
    (2, "Bob", "Bob"),
    (3, "Charlie", "Charlie");

INSERT INTO film
    (film_id, title, language_id)
VALUES
    (1, "aaa", 1),
    (2, "bbb", 1);

INSERT INTO film_actor
    (actor_id, film_id)
VALUES
    (2, 1),
    (2, 2);
