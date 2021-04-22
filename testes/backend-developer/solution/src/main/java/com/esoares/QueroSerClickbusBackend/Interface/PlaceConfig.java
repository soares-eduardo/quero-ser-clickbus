package com.esoares.QueroSerClickbusBackend.Interface;

import com.esoares.QueroSerClickbusBackend.BusinessLogic.IPlaceRepository;
import com.esoares.QueroSerClickbusBackend.BusinessLogic.Place;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlaceConfig {

    @Bean
    CommandLineRunner commandLineRunner(IPlaceRepository repository) {
        return args -> {

            Place centralParkCoffee = new Place(1L, "Central Park Coffee", "New York City", "NY");

            repository.insert(centralParkCoffee);
        };
    }
}
