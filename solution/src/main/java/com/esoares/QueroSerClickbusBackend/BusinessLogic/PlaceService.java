package com.esoares.QueroSerClickbusBackend.BusinessLogic;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

    private final IPlaceRepository placeRepository;

    @Autowired
    public PlaceService(IPlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> getPlaces() {
        return placeRepository.findAll();
    }

    public List<Place> getPlacesByName(String placeName) {
        return placeRepository.findPlacesByName(placeName);
    }

    public Place getPlaceBySlug(String placeSlug) {
        return placeRepository.findPlaceBySlug(placeSlug);
    }

    public void addNewPlace(Place place) {
        Place objPlace = new Place(place.getName(), place.getCity(), place.getState());
        Long id = placeRepository.insert(objPlace).getId();
        updateSlug(id);
    }

    public void deletePlace(Long placeId) {
        boolean exists = placeRepository.selectById(placeId);
        if (!exists) {
            throw new IllegalStateException("Place with id " + placeId + " does not exist.");
        }
        placeRepository.deleteById(placeId);
    }

    public void updateSlug(Long id) {
        Place place = placeRepository.findPlaceById(id).get();
        place.setSlug(place.getName(), id);
        placeRepository.insert(place);
    }

    @Transactional
    public void updatePlace(Long placeId, String name, String city, String state) {

        Place place = placeRepository.findPlaceById(placeId)
                .orElseThrow(() -> new IllegalStateException("Place with id " + placeId + " does not exist."));

        if (name != null && name.length() > 0 && !Objects.equals(place.getName(), name)) {
            place.setName(name);
            place.setSlug(name, place.getId());
        }

        if (city != null && city.length() > 0 && !Objects.equals(place.getCity(), city)) {
            place.setCity(city);
        }

        if (state != null && state.length() > 0 && !Objects.equals(place.getState(), state)) {
            place.setState(state);
        }
    }
}
