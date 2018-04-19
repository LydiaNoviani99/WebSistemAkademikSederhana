package com.lydia.entity;
// Generated Apr 12, 2018 3:30:53 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Student generated by hbm2java
 */
@Entity
@Table(name="student"
    ,catalog="ujitarobby_attendance_system"
)
public class Student  implements java.io.Serializable {


     private String id;
     private Department department;
     private String name;
     private String password;
     private Set<ClassSchedule> classSchedules = new HashSet<ClassSchedule>(0);

    public Student() {
    }

	
    public Student(String id, Department department, String name, String password) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.password = password;
    }
    public Student(String id, Department department, String name, String password, Set<ClassSchedule> classSchedules) {
       this.id = id;
       this.department = department;
       this.name = name;
       this.password = password;
       this.classSchedules = classSchedules;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false, length=12)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department_id", nullable=false)
    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }

    
    @Column(name="name", nullable=false, length=120)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="password", nullable=false, length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="student_contract", catalog="ujitarobby_attendance_system", joinColumns = { 
        @JoinColumn(name="student_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="class_schedule_class_selection", nullable=false, updatable=false) })
    public Set<ClassSchedule> getClassSchedules() {
        return this.classSchedules;
    }
    
    public void setClassSchedules(Set<ClassSchedule> classSchedules) {
        this.classSchedules = classSchedules;
    }




}


