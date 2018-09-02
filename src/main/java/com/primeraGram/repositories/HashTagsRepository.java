package com.primeraGram.repositories;

import com.primeraGram.models.HashTags;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashTagsRepository extends MongoRepository<HashTags, String> {
}
