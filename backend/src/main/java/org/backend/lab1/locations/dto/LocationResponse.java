package org.backend.lab1.locations.dto;

public record LocationResponse(
        Long id,
        Double x,
        Long y,
        Double z
) {
}
