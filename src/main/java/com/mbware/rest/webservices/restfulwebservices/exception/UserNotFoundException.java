package com.mbware.rest.webservices.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {
        super("No user is found with id: " + id);
    }

    public UserNotFoundException(String name) {
        super("No user is found with name: " + name);
    }
}
