package com.redhat.developers;

import java.util.List;
import java.util.stream.StreamSupport;

import org.bson.Document;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieRepository implements PanacheMongoRepository<Movie> {
    
    public List<Movie> getRandomMovies(Integer count) {
        var aggIter = mongoCollection().aggregate(
            List.of(new Document("$sample",new Document("size",count))),
            Movie.class
        );
        return StreamSupport.stream(aggIter.spliterator(), false).toList();
    }

}

