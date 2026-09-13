package org.backend.lab1.person.dto;

import org.backend.lab1.enums.Color;
import org.backend.lab1.enums.Country;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public record PersonResponse(
        Long id,
        String name,
        Coordinates coordinates,
        LocalDateTime creationDate
        Color eyeColor,
        Color hairColor,
        Location location,
        Double height,
        ZonedDateTime birthday,
        Double weight,
        Country nationality
) {
}
