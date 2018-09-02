package com.primeraGram.controllers;

import com.primeraGram.models.User;
import com.primeraGram.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
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
    public ResponseEntity<User> create(@Valid @RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateQuestion(@RequestBody User user) {
        User u = userRepository.save(user);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQuestion(@PathVariable("id") String id) {
        userRepository.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}