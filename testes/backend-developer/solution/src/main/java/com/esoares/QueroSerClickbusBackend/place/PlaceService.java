package com.esoares.QueroSerClickbusBackend.place;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> getPlaces() {
        return placeRepository.findAll();
    }

    public void addNewPlace(Place place){
        System.out.println(place);
    }
}
