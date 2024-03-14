package com.redhat.developers;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MovieService {

    @Inject
    MovieMapper movieMapper;
    
    public List<MovieDTO> getAllMovies() {
        return Movie.<Movie>listAll().stream()
                .map(movieMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MovieDTO getMovieById(String id) {
        return movieMapper.toDTO(Movie.findById(new ObjectId(id)));
    }

    public MovieDTO addMovie(MovieDTO dto) {
        var movie = movieMapper.toEntity(dto);
        movie.id = null;
        Movie.persist(movie);
        return movieMapper.toDTO(movie);
    }

}
