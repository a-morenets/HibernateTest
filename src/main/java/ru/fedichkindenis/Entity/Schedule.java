package ru.fedichkindenis.Entity;

import ru.fedichkindenis.Enum.DayWeek;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "teacher", referencedColumnName = "id", insertable = false, updatable = false)
    private Teacher teacher;

    @Column(name = "num_room")
    private String numRoom;

    @Column(name = "subject")
    private String subject;

    @Column(name = "day_week")
    @Enumerated(EnumType.STRING)
    private DayWeek dayWeek;

    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;

    public long getId() {
        return id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(String numRoom) {
        this.numRoom = numRoom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public DayWeek getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(DayWeek dayWeek) {
        this.dayWeek = dayWeek;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
