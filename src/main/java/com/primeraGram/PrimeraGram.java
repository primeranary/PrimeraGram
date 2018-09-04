package com.primeraGram;

import com.primeraGram.controllers.FileUploadController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication
@ComponentScan({"com.primeraGram", "com.primeraGram.controllers"})
public class PrimeraGram {


    public static void main(String[] args) {
        new File(FileUploadController.uploadDirectory).mkdir();
        SpringApplication.run(PrimeraGram.class, args);
    }
}
