package com.cinefolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.cinefolio.model.Movie;
import com.cinefolio.service.MovieService;

@Controller
public class MovieController {

    private final MovieService movieService;

    // Constructor dependency injection
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Display the home page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Display all movies
    @GetMapping("/movies")
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies";
    }

    // Display the add movie form
    @GetMapping("/movies/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "add-movie";
    }

    // Save a new movie
    @PostMapping("/movies/add")
    public String addMovie(@ModelAttribute Movie movie) {
        movie.setId(null);
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    // Display the edit movie form
    @GetMapping("/movies/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Movie movie = movieService.getMovieById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Movie not found"));

        model.addAttribute("movie", movie);
        return "edit-movie";
    }

    // Update an existing movie
    @PostMapping("/movies/edit/{id}")
    public String updateMovie(@PathVariable("id") Integer id,
                              @ModelAttribute Movie movie) {
        movieService.getMovieById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Movie not found"));

        movie.setId(id);
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    // Delete a movie
    @PostMapping("/movies/delete/{id}")
    public String deleteMovie(@PathVariable("id") Integer id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}
