package com.mchindwhite.backendtechnical.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String firstName;

    @Column String lastName;
/**Local Date is a date without a time. You can use it for birthdates, anniversaries, date joined etc. New as of Java 8 */
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

    public Person(long id, String firstName, String lastName, LocalDate dob, LocalDate dateJoined, LocalDate dateUpdated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.dateJoined = dateJoined;
        this.dateUpdated = dateUpdated;
    }

    public Person(String firstName, String lastName, LocalDate dob, LocalDate dateJoined, LocalDate dateUpdated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.dateJoined = dateJoined;
        this.dateUpdated = dateUpdated;
    }

    //one person can have many jobs?
//    @OneToMany(mappedBy = "person")
//    private List<Job> jobs;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
