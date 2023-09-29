package com.infy.services;

import com.infy.dtos.UserDto;
import com.infy.entities.User;
import com.infy.exceptions.UserNotFoundException;
import com.infy.repositories.UserRepository;
import com.infy.util.Messages;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private Environment environment;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper, Environment environment) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.environment = environment;
    }

    public UserDto addUser(UserDto newUserDto) {
        User newUser = userRepository.saveAndFlush(modelMapper.map(newUserDto, User.class));
        return modelMapper.map(newUser, UserDto.class);
    }

    public List<UserDto> getUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        userList.forEach(user -> userDtoList.add(modelMapper.map(user, UserDto.class)));

        return userDtoList;
    }

    public UserDto updateUser(int id, UserDto updatedUserDto) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()) {
            System.out.println("Messages: " + Messages.USER_NOT_FOUND.toString());
            throw new UserNotFoundException(environment.getProperty(Messages.USER_NOT_FOUND.toString()));
        }

        User userToBeUpdated = userOptional.get();
        userToBeUpdated.setEmail(updatedUserDto.getEmail());
        return modelMapper.map(userRepository.saveAndFlush(userToBeUpdated), UserDto.class);
    }
}
