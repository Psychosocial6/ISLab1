package org.backend.lab1.utils;

import org.backend.lab1.locations.LocationEntity;
import org.backend.lab1.locations.dto.LocationResponse;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public LocationResponse fromEntity(LocationEntity locationEntity) {
        if (locationEntity == null) {
            return null;
        }

        return new LocationResponse(
                locationEntity.getId(),
                locationEntity.getX(),
                locationEntity.getY(),
                locationEntity.getZ()
        );
    }
}
