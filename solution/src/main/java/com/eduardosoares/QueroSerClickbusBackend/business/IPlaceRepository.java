package com.eduardosoares.QueroSerClickbusBackend.business;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPlaceRepository {
    List<Place> findAllPlaces();
    Optional<Place> findPlaceBySlug(String slug);
    List<Place> findPlacesByName(String name);
    Optional<Place> findPlaceById(Long id);
    Place insertPlace(Place body);
    boolean isPlacePresent(Long id);
    void deleteById(Long id);
}
