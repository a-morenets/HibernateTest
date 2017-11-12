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

    @Column(name = "teacher")
    @JoinColumn(name = "id")
    private Teacher teacher;

    @Column(name = "num_room")
    private String numRoom;

    @Column(name = "subject")
    private String subject;

    @Column(name = "day_week")
    @Enumerated(EnumType.ORDINAL)
    private DayWeek dayWeek;

    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
}
