package com.primeraGram.controllers;

import com.primeraGram.models.Pictures;
import com.primeraGram.models.Profile;
import com.primeraGram.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public class ProfileController {
    @Autowired
    ProfileRepository profileRepository;

    @GetMapping(value = "/{id}")
    public Optional<Profile> getProfileById(@PathVariable("id") String id){
        return profileRepository.findById(id);
    }

    @GetMapping(value = "/")
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Profile> create(@Valid @RequestBody Profile profile){
        profileRepository.save(profile);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Profile profile) {
        Profile p = profileRepository.save(profile);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        profileRepository.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
