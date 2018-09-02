package com.primeraGram.controllers;

import com.primeraGram.models.Message;
import com.primeraGram.repositories.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/message")
public class MessagesController {
    @Autowired
    MessagesRepository messagesRepository;

    @GetMapping(value = "/{id}")
    public Optional<Message> getMessageById(@PathVariable("id") String id){
        return messagesRepository.findById(id);
    }

    @GetMapping(value = "/")
    public List<Message> getAllMessages() {
        return messagesRepository.findAll();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Message> create(@Valid @RequestBody Message message){
        messagesRepository.save(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Message message) {
        Message m = messagesRepository.save(message);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        messagesRepository.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
