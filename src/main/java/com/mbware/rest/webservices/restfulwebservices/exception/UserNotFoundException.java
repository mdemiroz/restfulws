package com.mbware.rest.webservices.restfulwebservices.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {
        super("No user is found with id: " + id);
    }

    public UserNotFoundException(String name) {
        super("No user is found with name: " + name);
    }
}
