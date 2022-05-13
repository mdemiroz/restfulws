package com.mbware.rest.webservices.restfulwebservices.service;

import com.mbware.rest.webservices.restfulwebservices.model.User;
import com.mbware.rest.webservices.restfulwebservices.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
            return user.get();
        return null;
    }

    public User findByName(String name) {
        Optional<User> user = userRepository.findByName(name);
        if(user.isPresent())
            return user.get();
        return null;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User deleteUserById(Integer id) {
        return userRepository.deleteById(id);
    }
}
