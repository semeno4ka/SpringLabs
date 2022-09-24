package com.cydeo.lab04springmvc.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Profile {
    private String email;
    private String phoneNumber;
    private String name;
    private String surname;
    private String userName;
    private LocalDateTime createdDate;

    public Profile(String email, String phoneNumber, String name, String surname, String userName, LocalDateTime createdDate) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.createdDate = createdDate;
    }
}
