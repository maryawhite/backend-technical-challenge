package com.mchindwhite.backendtechnical.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String position;

    public Job() {
    }

    public Job(long id, String position) {
        this.id = id;
        this.position = position;
    }

    public Job(String position) {
        this.position = position;
    }


    //one to many, one job can have many people
//    @ManyToOne
//    @JoinColumn(name = "person_id")
//    private Person person;

    @OneToMany(mappedBy = "job")
    private List<Person> persons;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
