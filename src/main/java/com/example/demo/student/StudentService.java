package com.example.demo.student;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class StudentService {

    public List<Student> getStudent() {
        return List.of(new Student(68, LocalDate.of(1965, Month.SEPTEMBER, 27), "PaoloBrosio@gmail.com", 1L, "Paolo"));
    }














}
