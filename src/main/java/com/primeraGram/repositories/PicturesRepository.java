package com.primeraGram.repositories;

import com.primeraGram.models.Pictures;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PicturesRepository extends MongoRepository<Pictures, String> {
}
