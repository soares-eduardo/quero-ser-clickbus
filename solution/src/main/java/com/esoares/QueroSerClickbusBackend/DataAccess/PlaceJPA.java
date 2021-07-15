package com.esoares.QueroSerClickbusBackend.DataAccess;

import java.util.List;

import com.esoares.QueroSerClickbusBackend.BusinessLogic.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlaceJPA extends JpaRepository<Place, Long>{
    
    @Query(value = "SELECT p FROM Place p WHERE p.name = ?1")
    List<Place> findPlacesByName (String name);

    @Query(value = "SELECT p from Place p WHERE p.slug = ?1")
    Place findPlaceBySlug (String slug);

}
