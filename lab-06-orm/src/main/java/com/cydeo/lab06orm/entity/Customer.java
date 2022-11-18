package com.cydeo.lab06orm.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class Customer extends BaseEntity {

    private String email;
    private String firstName;
    private String lastName;
    private String userName;



}
