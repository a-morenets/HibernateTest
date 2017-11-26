package ru.fedichkindenis.Entity;

import javax.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String num;

    @OneToOne(mappedBy = "room")
    private Teacher teacher;

    public void setNum(String num) {
        this.num = num;
    }

    public long getId() {
        return id;
    }

    public String getNum() {
        return num;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
