package com.infy.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@JsonIgnoreProperties(value = {"password"}, allowSetters = true)
@Data
public class UserDto {

    private int id;

    @Size(min = 3, max = 50, message = "{name.size.must}")
    private String name;

    private char gender;

    private LocalDate dob;

    @Size(min = 8, max = 32, message = "{password.size.must}")
    private String password;

    @Size(min = 10, max = 10, message = "{phoneNumber.size.must}")
    private String phoneNumber;

    @Email(message = "{email.invalid}")
    @NotNull(message = "{email.must}")
    private String email;

    @Size(min = 4, max = 4, message = "{pin.size.must")
    private String pin;

    @Size(min = 3, max = 20, message = "{city.size.must}")
    private String city;

    @Size(min = 3, max = 20, message = "{state.size.must}")
    private String state;

    @Size(min = 3, max = 20, message = "{country.size.must}")
    private String country;
}
