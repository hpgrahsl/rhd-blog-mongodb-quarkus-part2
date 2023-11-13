package com.redhat.developers;

import java.net.URI;
import java.util.List;

import org.bson.types.ObjectId;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("api/movie")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

    @GET
    public List<Movie> allMovies() {
        return Movie.listAll();
    }

    @GET
    @Path("{id}")
    public Response getMovie(@PathParam("id") String id) {
        var movie = Movie.findById(new ObjectId(id));
        return movie != null  
            ? Response.ok(movie).build() 
            : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addMovie(Movie movie) {
        movie.persist();
        return Response.created(URI.create("/api/movies"+movie.id)).entity(movie).build();
    }
    
}

