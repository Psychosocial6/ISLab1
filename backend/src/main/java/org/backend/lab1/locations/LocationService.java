package org.backend.lab1.locations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.backend.lab1.locations.dto.LocationResponse;
import org.backend.lab1.utils.LocationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public List<LocationResponse> getLocations() {
        return locationRepository.findAll()
                .stream()
                .map(locationMapper::fromEntity)
                .toList();
    }
}
