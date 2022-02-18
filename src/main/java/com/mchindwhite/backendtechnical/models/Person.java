package com.mchindwhite.backendtechnical.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private LocalDate dob;

    @Column
    private LocalDate dateJoined;

    @Column
    private LocalDate dateUpdated;

    @Transient
    private Integer age; //we want age to be transient bc you can calculate age with Now-dob, now it will not be a column in the db

    public Person() {
    }

    public Person(long id, String name, LocalDate dob, LocalDate dateJoined, LocalDate dateUpdated) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.dateJoined = dateJoined;
        this.dateUpdated = dateUpdated;
    }

    public Person(String name, LocalDate dob, LocalDate dateJoined, LocalDate dateUpdated) {
        this.name = name;
        this.dob = dob;
        this.dateJoined = dateJoined;
        this.dateUpdated = dateUpdated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
