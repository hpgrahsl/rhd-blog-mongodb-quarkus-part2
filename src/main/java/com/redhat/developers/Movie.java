package com.redhat.developers;

import java.util.List;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "movies")
public class Movie {
    public ObjectId id;
    public String title;
    public List<String> genre;
    public Integer duration;
    public Boolean released;
    public Integer year;
}
