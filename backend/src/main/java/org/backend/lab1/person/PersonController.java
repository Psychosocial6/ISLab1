package org.backend.lab1.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.backend.lab1.person.dto.PersonRequest;
import org.backend.lab1.person.dto.PersonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/persons")
@RestController
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonResponse>> getPersons() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> getPerson(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest personRequest) {
        return null;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PersonResponse> updatePerson(@PathVariable Long id, @RequestBody PersonRequest personRequest) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        return null;
    }
}
