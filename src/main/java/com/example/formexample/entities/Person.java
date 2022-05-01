package com.example.formexample.entities;

import org.springframework.context.annotation.Bean;

import java.util.concurrent.ConcurrentHashMap;

public class Person {

    public static final String PERSONS_MAP = "persons";

    private String firstName;
    private String lastName;
    private int age;

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
