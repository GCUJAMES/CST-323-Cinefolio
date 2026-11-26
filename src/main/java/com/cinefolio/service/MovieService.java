package com.cinefolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cinefolio.model.Movie;
import com.cinefolio.repository.MovieRepository;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    // Constructor dependency injection
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Retrieve all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Retrieve a movie by its ID
    public Optional<Movie> getMovieById(Integer id) {
        return movieRepository.findById(id);
    }

    // Create or update a movie
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Delete a movie
    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }
}

