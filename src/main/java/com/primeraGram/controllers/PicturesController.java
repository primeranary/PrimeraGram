package com.primeraGram.controllers;

import com.primeraGram.models.Pictures;
import com.primeraGram.repositories.PicturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public class PicturesController {
    @Autowired
    PicturesRepository picturesRepository;

    @GetMapping(value = "/{id}")
    public Optional<Pictures> getPictureById(@PathVariable("id") String id){
        return picturesRepository.findById(id);
    }

    @GetMapping(value = "/")
    public List<Pictures> getAllPictures() {
        return picturesRepository.findAll();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Pictures> create(@Valid @RequestBody Pictures pictures){
        picturesRepository.save(pictures);
        return new ResponseEntity<>(pictures, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Pictures pictures) {
        Pictures p = picturesRepository.save(pictures);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        picturesRepository.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
