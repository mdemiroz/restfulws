package com.mbware.rest.webservices.restfulwebservices.repository;

import com.mbware.rest.webservices.restfulwebservices.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    static List<User> list = new ArrayList<>();
    static int size = 3;

    static {
        list.add(new User(1, "ali", new Date()));
        list.add(new User(2, "veli", new Date()));
        list.add(new User(3, "deli", new Date()));
    }

    public Optional<User> findById(Integer id) {
        Optional<User> user = Optional.empty();
        for(User u : list)
            if(u.getId().equals(id))
                user = Optional.of(u);
        return user;
    }

    public Optional<User> findByName(String name) {
        Optional<User> user = Optional.empty();
        for(User u : list)
            if(u.getName().equals(name))
                user = Optional.of(u);
        return user;
    }

    public User save(User user) {
        if(user.getId() == null)
            user.setId(++size);
        list.add(user);
        return user;
    }

}
