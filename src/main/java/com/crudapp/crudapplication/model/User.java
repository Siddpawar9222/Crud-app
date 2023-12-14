package com.crudapp.crudapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "crud_user")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String name;
    private String education;
    private String skills;

    public User(String name, String education, String skills) {
        this.name = name;
        this.education = education;
        this.skills=skills;
    }
}
//@Data : toString, equals, hashCode, and getters/setters for all fields.