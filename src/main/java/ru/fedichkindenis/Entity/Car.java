package ru.fedichkindenis.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String num;

    @Column
    private String model;

    @ManyToMany(mappedBy = "carSet")
    private Set<Teacher> teacherSet = new HashSet<Teacher>();

    public void setNum(String num) {
        this.num = num;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getId() {
        return id;
    }

    public String getNum() {
        return num;
    }

    public String getModel() {
        return model;
    }

    public Set<Teacher> getTeacherSet() {
        return teacherSet;
    }
}
