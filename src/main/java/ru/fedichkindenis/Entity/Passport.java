package ru.fedichkindenis.Entity;

import javax.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String num;

    @Column
    private String series;

    @OneToOne(mappedBy = "passport")
    private Teacher teacher;

    public long getId() {
        return id;
    }

    public String getNum() {
        return num;
    }

    public String getSeries() {
        return series;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
