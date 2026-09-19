package org.backend.lab1.utils;

import lombok.RequiredArgsConstructor;
import org.backend.lab1.persons.PersonEntity;
import org.backend.lab1.persons.dto.PersonResponse;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PersonMapper {
    private final CoordinatesMapper coordinatesMapper;
    private final LocationMapper locationMapper;

    public PersonResponse fromEntity(PersonEntity personEntity) {
        return new PersonResponse(
                personEntity.getId(),
                personEntity.getName(),
                coordinatesMapper.fromEntity(personEntity.getCoordinates()),
                personEntity.getCreationDate(),
                personEntity.getEyeColor(),
                personEntity.getHairColor(),
                locationMapper.fromEntity(personEntity.getLocation()),
                personEntity.getHeight(),
                personEntity.getBirthday(),
                personEntity.getWeight(),
                personEntity.getNationality()
        );
    }
}
