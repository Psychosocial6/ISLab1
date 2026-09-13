package org.backend.lab1.locations.dto;

import jakarta.validation.constraints.NotNull;

public record LocationRequest(
        @NotNull(message = "location x required")
        Double x,
        @NotNull(message = "location y required")
        Long y,
        @NotNull(message = "location z required")
        Double z
) {
}
