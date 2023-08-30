package com.example.demo.model;

public class Course {
    private Integer id;
    private String name;

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
