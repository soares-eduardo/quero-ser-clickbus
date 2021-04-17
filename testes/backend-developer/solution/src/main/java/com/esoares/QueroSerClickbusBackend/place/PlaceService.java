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

    // TODO Verify if the place is already registered in the database
    public void addNewPlace(Place place) {
        Place objPlace = new Place(place.getName(), place.getCity(), place.getState(), place.getUpdatedAt());
        placeRepository.save(objPlace);
    }

    public void deletePlace(Long placeId) {
        boolean exists = placeRepository.existsById(placeId);
        if (!exists) {
            throw new IllegalStateException("Place with id " + placeId + " does not existis.");
        }
        placeRepository.deleteById(placeId);
    }
}
