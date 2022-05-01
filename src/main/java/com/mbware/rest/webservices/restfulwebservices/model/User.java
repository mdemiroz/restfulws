package com.mbware.rest.webservices.restfulwebservices.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "id")
public class User {
    private Integer id;
    private String name;
    private Date birthDate;

    public User(String name) {
        this.name = name;
    }
}
