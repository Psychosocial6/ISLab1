package org.backend.lab1.persons;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.backend.lab1.enums.Color;
import org.backend.lab1.persons.dto.PersonRequest;
import org.backend.lab1.persons.dto.PersonResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public List<PersonResponse> getPersons() {

    }

    public PersonResponse getPersonById(Long id) {

    }

    public PersonResponse createPerson(PersonRequest personRequest) {

    }

    public PersonResponse updatePerson(Long id, PersonRequest personRequest) {

    }

    public void deletePerson(Long id) {
    }

    public void deleteByHeight(Double height) {

    }

    public Map<String, Double> getAverageHeight() {

    }

    public Map<String, Long> countNationalityLessThan() {

    }

    public Map<String, Long> countHairColor(Color color) {

    }

    public Map<String, Double> getHairColorPercentage(Color color) {

    }
}
