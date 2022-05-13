package com.mbware.rest.webservices.restfulwebservices.model;

import lombok.*;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "id")
public class User {
    private Integer id;
    @Size(min=3, max=30, message="name should be between 3 and 30!")
    private String name;
    @Past
    private Date birthDate;

    public User(String name) {
        this.name = name;
    }
}
