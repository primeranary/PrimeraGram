package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<User> getUserById(@PathVariable("id") String id){
        return userRepository.findById(id);

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> create(@Valid @RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }
}