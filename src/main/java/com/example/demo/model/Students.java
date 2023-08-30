package com.example.demo.model;

public class Students {
    private Integer id;
    private String name;
    private String lastname;
    private Integer age;
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Students(Integer id, String name, String lastname, Integer age,Course course) {
        this.id = id;
        this.name = name;
        this.lastname=lastname;
        this.age=age;
        this.course=course;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Students() {
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
