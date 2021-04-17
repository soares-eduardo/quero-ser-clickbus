package com.esoares.QueroSerClickbusBackend.place;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/place")
public class PlaceController {

    @GetMapping
	public List<Place> getPlaces() {
		return List.of(new Place(1L, "Central Park", "central-park", "New York", "NY",
				new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
	}
    
}