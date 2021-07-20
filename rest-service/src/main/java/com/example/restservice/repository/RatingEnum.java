package com.example.restservice.repository;

import lombok.Getter;

public enum RatingEnum {
    G("G"),
    PG("PG"),
    PG13("PG-13"),
    R("R"),
    NC17("NC-17");

    @Getter
    private String rating;

    RatingEnum(String rating) {
        this.rating = rating;
    }
}
