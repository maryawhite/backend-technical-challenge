package com.mchindwhite.backendtechnical.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private LocalDate dob;

    @Column
    private LocalDate dateJoined;

    @Column
    private LocalDate dateUpdated;

    @Transient
    private Integer age; //we want age to be transient bc you can calculate age with Now-dob, now it will not be a column in the db

}
