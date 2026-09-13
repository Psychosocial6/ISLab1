package org.backend.lab1.locations;

import lombok.RequiredArgsConstructor;
import org.backend.lab1.locations.dto.LocationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/location")
@RestController
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<LocationResponse> getLocations() {
        return null;
    }
}
