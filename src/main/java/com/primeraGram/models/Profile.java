package com.primeraGram.models;

import org.springframework.context.annotation.DependsOn;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profile")
public class Profile {
    @Id
    private String id;
    private String name;
    private String username;
    private String email;
    private String bio;


}
