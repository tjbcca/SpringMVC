package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student joey = new Student(
                    "Joey",
                    "joeyman@gmail.com",
                    LocalDate.of(2006, FEBRUARY, 15)
            );
            Student mariam = new Student(
                    "Mariam",
                    "mariam@gmail.com",
                    LocalDate.of(2000, JANUARY, 5)
            );
            repository.saveAll(
                    List.of(joey,mariam)
            );
        };
    }
}
