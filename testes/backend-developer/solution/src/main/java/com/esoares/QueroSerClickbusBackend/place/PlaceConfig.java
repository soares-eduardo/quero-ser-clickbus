package com.esoares.QueroSerClickbusBackend.place;

import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlaceConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(PlaceRepository repository) {
        return args -> {

            String name = "Central Park Coffee";
            String slug =  name.replace(" ", "-").toLowerCase();

            Place centralParkCoffee = new Place(
                1L,
                name,
                slug,
                "New York City",
                "NY",
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis())
            );

            repository.saveAll(List.of(centralParkCoffee));

        };
    }
}
