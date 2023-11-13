package com.redhat.developers;

import java.util.List;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "movies")
public class Movie extends PanacheMongoEntity {
    public String title;
    public List<String> genre;
    public Integer duration;
    public Boolean released;
    public Integer year;
}
