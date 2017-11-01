package ru.fedichkindenis.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Teacher")
public class Teacher {

    @Id
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "surname")
    private String surName;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_birth")
    private Date dateBirth;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;
}
