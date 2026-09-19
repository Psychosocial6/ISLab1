package org.backend.lab1.exceptions.custom;

public class LocationNotFoundException extends NotFoundException {
    public LocationNotFoundException(Long id) {
        super(String.format("Location id=%s not found", id));
    }
}
