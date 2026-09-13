package org.backend.lab1.person.dto;

import org.backend.lab1.enums.Color;
import org.backend.lab1.enums.Country;

import java.time.ZonedDateTime;

public record PersonRequest(
        String name,
        Coordinates coordinates,
        Color eyeColor,
        Color hairColor,
        Location location,
        Double height,
        ZonedDateTime birthday,
        Double weight,
        Country nationality
) {
}
