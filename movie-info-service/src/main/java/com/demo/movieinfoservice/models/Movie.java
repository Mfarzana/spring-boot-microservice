package com.demo.movieinfoservice.models;

public class Movie {
    private String name;
    private String id;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public Movie() {
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Movie(String name, String id, String desc) {
        this.name = name;
        this.id = id;
        this.desc = desc;
    }

}
