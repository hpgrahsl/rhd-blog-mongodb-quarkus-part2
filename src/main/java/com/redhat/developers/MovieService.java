package com.redhat.developers;

import java.util.List;

import org.bson.types.ObjectId;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieService {

    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    public MovieService(MovieMapper movieMapper, MovieRepository movieRepository) {
        this.movieMapper = movieMapper;
        this.movieRepository = movieRepository;
    }
    
    public List<MovieDTO> getAllMovies() {
        return movieRepository.listAll().stream()
                .map(movieMapper::toDTO)
                .toList();
    }

    public MovieDTO getMovieById(String id) {
        return movieMapper.toDTO(movieRepository.findById(new ObjectId(id)));
    }

    public MovieDTO addMovie(MovieDTO dto) {
        var movie = movieMapper.toEntity(dto);
        movie.id = null;
        movieRepository.persist(movie);
        return movieMapper.toDTO(movie);
    }

    public List<MovieDTO> getRandomMovies(Integer count) {
        return movieRepository.getRandomMovies(count).stream()
            .map(movieMapper::toDTO).toList();
    }

}
