package com.esoares.QueroSerClickbusBackend.place;

import java.util.Date;
import java.util.List;

public class PlaceService {

    public List<Place> getPlaces() {
        return List.of(new Place(1L, "Central Park", "central-park", "New York", "NY",
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
    }
}
