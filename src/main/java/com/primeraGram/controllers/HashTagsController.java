package com.primeraGram.controllers;

import com.primeraGram.models.HashTags;
import com.primeraGram.repositories.HashTagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/hash")
public class HashTagsController {
    @Autowired
    HashTagsRepository hashTagsRepository;

    @GetMapping(value = "/{id}")
    public Optional<HashTags> getHashTagById(@PathVariable("id") String id){
        return hashTagsRepository.findById(id);
    }

    @GetMapping(value = "/")
    public List<HashTags> getAllHashTags() {
        return hashTagsRepository.findAll();
    }

    @PostMapping(value = "/")
    public ResponseEntity<HashTags> create(@Valid @RequestBody HashTags hash){
        hashTagsRepository.save(hash);
        return new ResponseEntity<>(hash, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody HashTags hash) {
        HashTags h = hashTagsRepository.save(hash);
        return new ResponseEntity<>(h,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        hashTagsRepository.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
