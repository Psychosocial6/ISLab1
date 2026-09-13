package org.backend.lab1.coordinates.dto;

import jakarta.validation.constraints.NotNull;

public record CoordinatesRequest(
        @NotNull(message = "coordinates x required")
        Float x,
        @NotNull(message = "coordinates y required")
        Float y
) {
}
