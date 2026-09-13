package org.backend.lab1.persons;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.backend.lab1.enums.Color;
import org.backend.lab1.enums.Country;
import org.backend.lab1.persons.dto.PersonRequest;
import org.backend.lab1.persons.dto.PersonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Validated
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonResponse>> getPersons() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> getPersonById(
            @NotNull(message = "person id required")
            @Positive(message = "person id must be positive")
            @PathVariable Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<PersonResponse> createPerson(
            @Valid
            @RequestBody PersonRequest personRequest) {
        return null;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PersonResponse> updatePerson(
            @NotNull(message = "person id required")
            @Positive(message = "person id must be positive")
            @PathVariable Long id,
            @Valid
            @RequestBody PersonRequest personRequest) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(
            @NotNull(message = "person id required")
            @Positive(message = "person id must be positive")
            @PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/delete-by-height")
    public ResponseEntity<Void> deleteByHeight(@RequestParam(name = "height") Double height) {
        return null;
    }

    @GetMapping("/avg-height")
    public ResponseEntity<Map<String, Double>> getAverageHeight() {
        return null;
    }

    @GetMapping("/count-nationality-less-than")
    public ResponseEntity<Map<String, Long>> countNationalityLessThan(
            @RequestParam(name = "nationality")
            Country nationality) {
        return null;
    }

    @GetMapping("/count-hair-color")
    public ResponseEntity<Map<String, Long>> countHairColor(@RequestParam(name = "hair-color") Color color) {
        return null;
    }

    @GetMapping("/hair-color-percentage")
    public ResponseEntity<Map<String, Double>> getHairColorPercentage(@RequestParam(name = "hair-color") Color color) {
        return null;
    }
}
