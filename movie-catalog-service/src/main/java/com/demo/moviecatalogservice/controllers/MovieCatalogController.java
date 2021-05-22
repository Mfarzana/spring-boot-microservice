package com.demo.moviecatalogservice.controllers;

import java.util.Collections;
import java.util.List;

import com.demo.moviecatalogservice.models.CatalogItem;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        System.out.println(" hello resource ");
        return Collections.singletonList(new CatalogItem("Transformer", "Robotics", 4));
    }
}
