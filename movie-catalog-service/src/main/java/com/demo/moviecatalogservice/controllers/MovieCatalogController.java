package com.demo.moviecatalogservice.controllers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.moviecatalogservice.models.CatalogItem;
import com.demo.moviecatalogservice.models.Movie;
import com.demo.moviecatalogservice.models.Rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        List<Rating> listRating = Arrays.asList(new Rating("test1", 1234), new Rating("test2", 3333));

        return listRating.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
        }).collect(Collectors.toList());

    }
}
