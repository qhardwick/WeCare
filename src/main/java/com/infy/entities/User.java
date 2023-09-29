package com.infy.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private char gender;

    private LocalDate dob;

    private String password;

    @Column(name = "phone_number")
    private long phoneNumber;

    private String email;

    private int pin;

    private String city;

    private String state;

    private String country;
}
