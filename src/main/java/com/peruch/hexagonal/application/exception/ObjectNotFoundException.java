package com.peruch.hexagonal.application.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String id) {
        super("object with id " + id + " not found");
    }
}
