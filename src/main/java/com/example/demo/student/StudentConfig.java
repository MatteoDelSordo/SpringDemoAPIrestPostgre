package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student paolo = new Student("Paolo", "paolobrosio@gmial.com", LocalDate.of(1956, Month.SEPTEMBER, 27));
            Student ciccio = new Student("Ciccio", "cicciovalente@gmail.com", LocalDate.of(1976, Month.JULY, 10));
            repository.saveAll(List.of(paolo, ciccio));
        };
    }

}
