package org.backend.lab1.persons.dto;

import org.backend.lab1.coordinates.dto.CoordinatesResponse;
import org.backend.lab1.enums.Color;
import org.backend.lab1.enums.Country;
import org.backend.lab1.locations.dto.LocationResponse;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public record PersonResponse(
        Long id,
        String name,
        CoordinatesResponse coordinates,
        LocalDateTime creationDate,
        Color eyeColor,
        Color hairColor,
        LocationResponse location,
        Double height,
        ZonedDateTime birthday,
        Double weight,
        Country nationality
) {
}
