package com.demo.moviecatalogservice.models;

public class Rating {
    private String name;
    private int id;

    public Rating() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rating(String name, int id) {
        this.name = name;
        this.id = id;
    }

}
