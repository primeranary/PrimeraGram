package com.primeraGram.controllers;

import com.primeraGram.models.Pictures;
import com.primeraGram.repositories.PicturesRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pictures")

public class PicturesController {
    @Autowired
    PicturesRepository picturesRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile multipart) {
        try {
            Pictures pictures = new Pictures();
            pictures.setFile(new Binary(BsonBinarySubType.BINARY, multipart.getBytes()));
            mongoTemplate.insert(pictures);
            System.out.println(pictures);
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
        return "success";
    }

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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        picturesRepository.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
