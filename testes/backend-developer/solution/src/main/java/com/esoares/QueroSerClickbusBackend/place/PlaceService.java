package com.esoares.QueroSerClickbusBackend.place;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

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

    public List<Place> getPlacesByName(String placeName) {
        return placeRepository.findPlaceByName(placeName);
    }

    // TODO Verify if the place is already registered in the database
    public void addNewPlace(Place place) {
        Place objPlace = new Place(place.getName(), place.getCity(), place.getState());
        placeRepository.save(objPlace);
    }

    public void deletePlace(Long placeId) {
        boolean exists = placeRepository.existsById(placeId);
        if (!exists) {
            throw new IllegalStateException("Place with id " + placeId + " does not exist.");
        }
        placeRepository.deleteById(placeId);
    }

    @Transactional
    public void updatePlace(Long placeId, String name, String city, String state) {

        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new IllegalStateException("Place with id " + placeId + " does not exist."));

        if (name != null && name.length() > 0 && !Objects.equals(place.getName(), name)) {
            place.setName(name);
            place.setSlug(name);
        }

        if (city != null && city.length() > 0 && !Objects.equals(place.getCity(), city)) {
            place.setCity(city);
        }

        if (state != null && state.length() > 0 && !Objects.equals(place.getState(), state)) {
            place.setState(state);
        }
    }
}
