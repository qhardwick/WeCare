package com.infy.controllers;

import com.infy.dtos.UserDto;
import com.infy.exceptions.UserNotFoundException;
import com.infy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Controller health check
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello User");
    }

    // Register new User account
    @PostMapping
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto newUserDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(newUserDto));
    }

    // View all Users:
    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    // Update User data
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") int id, @RequestBody UserDto updatedUserDto) throws UserNotFoundException {
        return ResponseEntity.ok(userService.updateUser(id, updatedUserDto));
    }
}
