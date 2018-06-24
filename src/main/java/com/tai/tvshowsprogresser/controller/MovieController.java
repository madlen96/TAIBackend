package com.tai.tvshowsprogresser.controller;

import com.tai.tvshowsprogresser.model.Movie;
import com.tai.tvshowsprogresser.repository.MovieRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class MovieController {
    private MovieRepository repository;

    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/good-movies")
    @CrossOrigin(origins = {"https://tv-shows-progresser.herokuapp.com","http://localhost:3000"})
    public Collection<Movie> goodMovies() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

}

