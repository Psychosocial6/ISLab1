package org.backend.lab1.exceptions;

import java.time.LocalDateTime;

public record ExceptionResponse(
        int status,
        String message,
        LocalDateTime time
) {
}
