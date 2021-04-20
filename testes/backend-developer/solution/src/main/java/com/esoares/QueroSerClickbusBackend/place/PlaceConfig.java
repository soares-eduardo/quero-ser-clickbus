package com.esoares.QueroSerClickbusBackend.place;

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

            Place centralParkCoffee = new Place(1L, name, "New York City", "NY");

            repository.saveAll(List.of(centralParkCoffee));

        };
    }
}
