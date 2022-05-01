package com.mbware.rest.webservices.restfulwebservices.controller;

import com.mbware.rest.webservices.restfulwebservices.model.User;
import com.mbware.rest.webservices.restfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        return userService.findByName(name);
    }

    @GetMapping( "user/id/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/user/add")
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

}
