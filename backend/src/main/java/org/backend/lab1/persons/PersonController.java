package org.backend.lab1.persons;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
