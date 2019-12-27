package com.example.springhateoas.model;

import org.springframework.hateoas.RepresentationModel;

public class User extends RepresentationModel {
    private String name;
    private Long salary;

    public User() {
    }

    public User(String name, Long salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }
}
