package com.example.tourist.config;

import com.example.tourist.model.Tourist;
import com.example.tourist.repository.TouristRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner loadSampleData(TouristRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Tourist("Ravi", "Hyderabad"));
                repository.save(new Tourist("Sita", "Vijayawada"));
                repository.save(new Tourist("Arjun", "Tirupati"));
            }
        };
    }
}
