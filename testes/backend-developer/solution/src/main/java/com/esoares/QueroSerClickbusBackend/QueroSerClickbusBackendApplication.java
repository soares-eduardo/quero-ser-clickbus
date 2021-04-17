package com.esoares.QueroSerClickbusBackend;

import java.util.Date;
import java.util.List;

import com.esoares.QueroSerClickbusBackend.place.Place;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class QueroSerClickbusBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueroSerClickbusBackendApplication.class, args);
	}

	@GetMapping
	public List<Place> hello() {
		return List.of(
			new Place(
				1L,
				"Central Park",
				"central-park",
				"New York",
				"NY",
				new Date(System.currentTimeMillis()),
				new Date(System.currentTimeMillis())
			)
		);
	}
}
