package com.mbware.rest.webservices.restfulwebservices.controller;

import com.mbware.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.mbware.rest.webservices.restfulwebservices.model.User;
import com.mbware.rest.webservices.restfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String helloWorld() {
        return "Naber la slak .s.s";
    }

    @GetMapping("/users")
    public List<User> user() {
        return userService.findAll();
    }

    @GetMapping("/users/name/{name}")
    public User getUserByName(@PathVariable String name) {
        User user = userService.findByName(name);
        if(user == null)
            throw new UserNotFoundException(name);
        return user;
    }

    @GetMapping("/users/id/{id}")
    public User getUserById(@PathVariable Integer id) {
        User user = userService.findById(id);
        if(user == null)
            throw new UserNotFoundException(id);
        return user;
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User usr = userService.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id/{id}").buildAndExpand(usr.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/user/id/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Integer id) {
        User user = userService.deleteUserById(id);
        if(user == null)
            throw new UserNotFoundException(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
