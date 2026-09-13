package org.backend.lab1.coordinates;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.backend.lab1.coordinates.dto.CoordinatesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/coordinates")
@RestController
public class CoordinatesController {
    private final CoordinatesService coordinatesService;

    @GetMapping
    public ResponseEntity<List<CoordinatesResponse>> getCoordinates() {
        return null;
    }
}
