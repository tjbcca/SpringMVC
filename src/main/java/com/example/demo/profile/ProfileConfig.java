package com.example.demo.profile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class ProfileConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProfileRepository repository) {
        return args -> {
            Profile joey = new Profile(
                    "Joey",
                    "joeyman@gmail.com",
                    LocalDate.of(2006, FEBRUARY, 15)
            );
            Profile mariam = new Profile(
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
