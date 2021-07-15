package com.esoares.QueroSerClickbusBackend.BusinessLogic;

import java.util.List;
import java.util.Optional;

public interface IPlaceRepository {
    
    public List<Place> findAll();

    public List<Place> findPlacesByName(String placeName);

    public Place findPlaceBySlug(String placeSlug);

    public Optional<Place> findPlaceById(Long id);

    public Place insert(Place place);

    public boolean selectById(Long id);

    public void deleteById(Long id);

}
