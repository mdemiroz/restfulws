package com.mbware.rest.webservices.restfulwebservices.controller;

import com.mbware.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.mbware.rest.webservices.restfulwebservices.model.User;
import com.mbware.rest.webservices.restfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@RestController("/")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String helloWorld() {
        return "Naber la slak .s.s";
    }

    @GetMapping("user")
    public String user() {
        return "What is users name or id or etc?";
    }

    @GetMapping("user/name/{name}")
    public User getUserByName(@PathVariable String name) {
        User user = userService.findByName(name);
        if(user == null)
            throw new UserNotFoundException(name);
        return user;
    }

    @GetMapping("user/id/{id}")
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

}
