package ru.fedichkindenis.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NamedQueries(
        @NamedQuery(
                name = "get_teacher_by_name",
                query = "from Teacher t where t.firstName = :name"
        )
)

@Entity
@Table(name = "Teacher")
public class Teacher {

    @Id
    @GeneratedValue
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

    @Column(name = "description", nullable = true, length = 51,columnDefinition = "varchar(46) not null")
    private String description;

    @OneToMany(mappedBy = "teacher")
    private List<Schedule> scheduleList;

    @OneToOne
    @JoinColumn(name = "passport")
    private Passport passport;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Assistant assistant;

    @OneToOne
    @JoinTable(name = "teacher_room",
            joinColumns = @JoinColumn(name = "id_teacher"),
            inverseJoinColumns = @JoinColumn(name = "id_room"))
    private Room room;

    @ManyToMany
    @JoinTable(name = "teacher_car",
            joinColumns = @JoinColumn(name = "id_teacher"),
            inverseJoinColumns = @JoinColumn(name = "id_car"))
    private Set<Car> carSet = new HashSet<Car>();

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void addCar(Car car) {
        carSet.add(car);
    }

    public Set<Car> getCarSet() {
        return carSet;
    }
}
