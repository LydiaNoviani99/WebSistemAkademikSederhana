package com.lydia.entity;
// Generated Apr 12, 2018 3:30:53 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Semester generated by hbm2java
 */
@Entity
@Table(name = "semester",
         catalog = "ujitarobby_attendance_system"
)
public class Semester implements java.io.Serializable {

    private int id;
    private String name;
    private Set<ClassSchedule> classSchedules = new HashSet<ClassSchedule>(0);

    public Semester() {
    }

    public Semester(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Semester(int id, String name, Set<ClassSchedule> classSchedules) {
        this.id = id;
        this.name = name;
        this.classSchedules = classSchedules;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "semester")
    public Set<ClassSchedule> getClassSchedules() {
        return this.classSchedules;
    }

    public void setClassSchedules(Set<ClassSchedule> classSchedules) {
        this.classSchedules = classSchedules;
    }

}
