package org.backend.lab1.locations.dto;

public record LocationRequest(
        Double x,
        Long y,
        Double z
) {
}
