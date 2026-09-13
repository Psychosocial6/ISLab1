package org.backend.lab1.persons.dto;

import org.backend.lab1.coordinates.dto.CoordinatesRequest;
import org.backend.lab1.enums.Color;
import org.backend.lab1.enums.Country;
import org.backend.lab1.locations.dto.LocationRequest;

import java.time.ZonedDateTime;

public record PersonRequest(
        String name,
        CoordinatesRequest coordinates,
        Long coordinatesId,
        Color eyeColor,
        Color hairColor,
        LocationRequest location,
        Long locationId,
        Double height,
        ZonedDateTime birthday,
        Double weight,
        Country nationality
) {
}
