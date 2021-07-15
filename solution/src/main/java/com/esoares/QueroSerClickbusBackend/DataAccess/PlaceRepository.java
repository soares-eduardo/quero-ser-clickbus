package com.esoares.QueroSerClickbusBackend.DataAccess;

import java.util.List;
import java.util.Optional;

import com.esoares.QueroSerClickbusBackend.BusinessLogic.IPlaceRepository;
import com.esoares.QueroSerClickbusBackend.BusinessLogic.Place;

import org.springframework.stereotype.Repository;

@Repository
public class PlaceRepository implements IPlaceRepository {

    private PlaceJPA placeJpa;

    public PlaceRepository(PlaceJPA placeJPA) {
        this.placeJpa = placeJPA;
    }

    public List<Place> findAll() {
        return placeJpa.findAll();
    }
        
    public List<Place> findPlacesByName(String placeName) {
        return placeJpa.findPlacesByName(placeName);
    }

    public Place findPlaceBySlug(String placeSlug) {
        return placeJpa.findPlaceBySlug(placeSlug);
    }
 
    public Optional<Place> findPlaceById(Long id) {
        return placeJpa.findById(id);
    }

    public Place insert(Place place) {
        return placeJpa.save(place);
    }

    public boolean selectById(Long id) {
        return placeJpa.existsById(id);
    }

    public void deleteById(Long id) {
        placeJpa.deleteById(id);
    }
}
