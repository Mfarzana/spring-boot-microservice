package com.demo.ratingdataservice.controllers;

import java.util.Arrays;
import java.util.List;

import com.demo.ratingdataservice.models.Rating;
import com.demo.ratingdataservice.models.UserRating;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingdata")
public class RatingController {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating("testId", 4);
    }

    @RequestMapping("user/{userId}")
    public UserRating tUserRatings(@PathVariable("userId") String userId) {
        List<Rating> listRating = Arrays.asList(new Rating("test1", 1234), new Rating("test2", 3333));
        UserRating userRating = new UserRating(listRating);
        return userRating;
    }
}
