package org.backend.lab1.utils;

import org.backend.lab1.coordinates.CoordinatesEntity;
import org.backend.lab1.coordinates.dto.CoordinatesResponse;
import org.springframework.stereotype.Component;

@Component
public class CoordinatesMapper {

    public CoordinatesResponse fromEntity(CoordinatesEntity coordinatesEntity) {
        return new CoordinatesResponse(
                coordinatesEntity.getId(),
                coordinatesEntity.getX(),
                coordinatesEntity.getY()
        );
    }
}
