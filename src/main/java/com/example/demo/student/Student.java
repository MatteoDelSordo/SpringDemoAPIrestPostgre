package com.example.demo.student;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    private String email;
    @Transient
    private Integer age;
    private LocalDate dob;

    public Student() {
    }

    public Student(LocalDate dob,
                   String email,
                   long id,
                   String name) {

        this.dob = dob;
        this.email = email;
        this.id = id;
        this.name = name;
    }

    public Student(String name,
                   String email,
                   LocalDate dob
                   ) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Integer getAge() {


        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "age=" + age + ", id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", "
                + "dob=" + dob + '}';
    }
}
