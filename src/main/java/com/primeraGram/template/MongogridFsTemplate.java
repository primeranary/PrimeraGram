package com.primeraGram.template;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

public class MongogridFsTemplate extends AbstractMongoConfiguration {

    @Value("${jsa.mongo.address}")
    private String mongoAddress;

    @Value("${jsa.mongo.database}")
    private String mongoDatabase;

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }

    @Override
    protected String getDatabaseName() {
        return mongoDatabase;
    }


    @Override
    public MongoClient mongoClient() {
        return new MongoClient(mongoAddress);
    }
}

