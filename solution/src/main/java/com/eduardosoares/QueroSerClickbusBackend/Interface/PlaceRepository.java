package com.eduardosoares.QueroSerClickbusBackend.Interface;

import com.eduardosoares.QueroSerClickbusBackend.Application.PlaceDTO;
import com.eduardosoares.QueroSerClickbusBackend.BusinessRules.IPlaceRepository;
import com.eduardosoares.QueroSerClickbusBackend.BusinessRules.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlaceRepository implements IPlaceRepository {

    @Autowired
    private PlaceJPA placeJpa;

    @Override
    public List<Place> findAllPlaces() {
        return placeJpa.findAll();
    }

    @Override
    public Optional<Place> findPlaceBySlug(String slug) {
        return placeJpa.findPlaceBySlug(slug);
    }

    @Override
    public List<Place> findPlacesByName(String name) {
        return placeJpa.findPlacesByName(name);
    }

    @Override
    public Optional<Place> findPlaceById(Long id) {
        return placeJpa.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        placeJpa.deleteById(id);
    }

    @Override
    public Place insertPlace(Place body) {
        return placeJpa.save(body);
    }

    @Override
    public boolean isPlacePresent(Long id) {
        return placeJpa.existsById(id);
    }
}
