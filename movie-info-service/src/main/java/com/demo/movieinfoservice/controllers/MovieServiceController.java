package com.demo.movieinfoservice.controllers;

import java.util.Collections;
import java.util.List;

import com.demo.movieinfoservice.models.Movie;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieServiceController {
    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        return new Movie("Tansformer", "1234", " Test Description");
    }
}
