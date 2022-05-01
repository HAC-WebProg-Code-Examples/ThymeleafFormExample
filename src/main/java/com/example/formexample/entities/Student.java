package com.example.formexample.entities;

public class Student {

    public static final int MIN_YEAR = 1;
    public static final int MAX_YEAR = 5;

    private String firstName;
    private String lastName;
    private Degree degree;
    private int year;
    private boolean graduated;

    public Student() {
    }

    public Student(String firstName, String lastName, Degree degree, int year, boolean graduated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
        setYear(year);
        this.graduated = graduated;
    }

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < MIN_YEAR || year > MAX_YEAR)
            throw new IllegalArgumentException("year must be in range " + MIN_YEAR + ":" + MAX_YEAR +", got " + year);
        this.year = year;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}
