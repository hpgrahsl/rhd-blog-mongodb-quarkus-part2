package com.redhat.developers;

import java.util.List;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.rest.data.panache.PanacheMongoRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

// ----------------------------------------------------------------------------
// NOTE: this auto-generated resource means that REST calls are directly wired
// to the data repository in question, meaning there's neither a service layer
// nor any kind of DTO mapping present in-between...
    
// ! Use this with caution for anything other than quick demos or POC code !
// ----------------------------------------------------------------------------
@ResourceProperties(path = "api/auto-gen/movie")
public interface MovieResourceAutoGen
    extends PanacheMongoRepositoryResource<MovieRepository,Movie,ObjectId> {

    //You can add your own custom methods with default implementations like so:
    @GET
    @Path("/random/{count}")
    @Produces(MediaType.APPLICATION_JSON)
    default List<Movie> getRandomMovies(@PathParam("count") Integer count) {
        return CDI.current()
            .select(MovieRepository.class).get()
            .getRandomMovies(count);
    }

}
