package com.demo.moviecatalogservice.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.demo.moviecatalogservice.models.CatalogItem;
import com.demo.moviecatalogservice.models.Movie;
import com.demo.moviecatalogservice.models.UserRating;

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

        UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingdata/user/" + userId,
                UserRating.class);
        return userRating.getUserRating().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
        }).collect(Collectors.toList());

    }
}
