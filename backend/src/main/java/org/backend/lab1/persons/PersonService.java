package org.backend.lab1.persons;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.backend.lab1.coordinates.CoordinatesEntity;
import org.backend.lab1.coordinates.CoordinatesRepository;
import org.backend.lab1.enums.Color;
import org.backend.lab1.enums.Country;
import org.backend.lab1.exceptions.custom.CoordinatesNotFoundException;
import org.backend.lab1.exceptions.custom.LocationNotFoundException;
import org.backend.lab1.exceptions.custom.PersonNotFoundException;
import org.backend.lab1.locations.LocationEntity;
import org.backend.lab1.locations.LocationRepository;
import org.backend.lab1.persons.dto.PersonRequest;
import org.backend.lab1.persons.dto.PersonResponse;
import org.backend.lab1.utils.PersonMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final CoordinatesRepository coordinatesRepository;
    private final LocationRepository locationRepository;
    private final PersonMapper personMapper;

    public List<PersonResponse> getPersons(Pageable pageable, String name) {
        return personRepository.findByNameContainingIgnoreCase(name, pageable);

    }

    public PersonResponse getPersonById(Long id) {
        return personRepository.findById(id)
                .map(personMapper::fromEntity)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Transactional
    public PersonResponse createPerson(PersonRequest personRequest) {
        PersonEntity personEntity = new PersonEntity(
                personRequest.name(),
                resolveCoordinates(personRequest),
                personRequest.eyeColor(),
                personRequest.hairColor(),
                resolveLocation(personRequest),
                personRequest.height(),
                personRequest.birthday(),
                personRequest.weight(),
                personRequest.nationality()
        );
        return personMapper.fromEntity(personRepository.save(personEntity));
    }

    @Transactional
    public PersonResponse updatePerson(Long id, PersonRequest personRequest) {
        PersonEntity personEntity = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        personEntity.setName(personRequest.name());
        personEntity.setCoordinates(resolveCoordinates(personRequest));
        personEntity.setEyeColor(personRequest.eyeColor());
        personEntity.setHairColor(personRequest.hairColor());
        personEntity.setLocation(resolveLocation(personRequest));
        personEntity.setHeight(personRequest.height());
        personEntity.setBirthday(personRequest.birthday());
        personEntity.setWeight(personRequest.weight());
        personEntity.setNationality(personRequest.nationality());

        return personMapper.fromEntity(personRepository.save(personEntity));
    }

    @Transactional
    public void deletePerson(Long id, Long transferToId) {
        PersonEntity personEntity = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        PersonEntity transferPersonEntity = personRepository.findById(transferToId)
                .orElseThrow(() -> new PersonNotFoundException(transferToId));
        transferPersonEntity.setCoordinates(personEntity.getCoordinates());
        if (personEntity.getLocation() != null) {
            transferPersonEntity.setLocation(personEntity.getLocation());
        }
        personRepository.save(transferPersonEntity);
        personRepository.delete(personEntity);
    }

    @Transactional
    public void deleteByHeight(Double height) {
        List<PersonEntity> personEntities = personRepository.findByHeight(height);
        personRepository.deleteAll(personEntities);
    }

    public Map<String, Double> getAverageHeight() {
        Double averageHeight = personRepository.findAll()
                .stream()
                .mapToDouble(PersonEntity::getHeight)
                .average()
                .orElse(0.0);
        return Map.of("average_height", averageHeight);
    }

    public Map<String, Long> countNationalityLessThan(Country nationality) {
        Long count = personRepository.findAll()
                .stream()
                .map(PersonEntity::getNationality)
                .filter(n -> n.compareTo(nationality) < 0)
                .count();
        return Map.of("count", count);
    }

    public Map<String, Long> countHairColor(Color color) {
        Long count = personRepository.findAll()
                .stream()
                .map(PersonEntity::getHairColor)
                .filter(c -> c.compareTo(color) == 0)
                .count();
        return Map.of("count", count);
    }

    public Map<String, Double> getHairColorPercentage(Color color) {
        List<PersonEntity> personEntities = personRepository.findAll();
        if (personEntities.isEmpty()) {
            return Map.of("percentage", 0.0D);
        }
        long count = personEntities
                .stream()
                .filter(c -> c.getHairColor() == color)
                .count();
        double percentage = ((double) count / personEntities.size()) * 100.0D;
        return Map.of("percentage", percentage);
    }

    private CoordinatesEntity resolveCoordinates(PersonRequest personRequest) {
        if (personRequest.coordinatesId() != null) {
            return coordinatesRepository.findById(personRequest.coordinatesId())
                    .orElseThrow(() -> new CoordinatesNotFoundException(personRequest.coordinatesId()));
        }

        CoordinatesEntity coordinates = new CoordinatesEntity(
                personRequest.coordinates().x(),
                personRequest.coordinates().y()
        );
        return coordinatesRepository.save(coordinates);
    }

    private LocationEntity resolveLocation(PersonRequest personRequest) {
        if (personRequest.locationId() != null) {
            return locationRepository.findById(personRequest.locationId())
                    .orElseThrow(() -> new LocationNotFoundException(personRequest.locationId()));

        }
        if (personRequest.location() != null) {
            LocationEntity locationEntity = new LocationEntity(
                    personRequest.location().x(),
                    personRequest.location().y(),
                    personRequest.location().z()
            );
            return locationRepository.save(locationEntity);
        }

        return null;
    }
}
