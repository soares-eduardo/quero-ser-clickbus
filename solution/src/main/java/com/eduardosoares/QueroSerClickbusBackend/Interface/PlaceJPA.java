package com.eduardosoares.QueroSerClickbusBackend.Interface;

import com.eduardosoares.QueroSerClickbusBackend.Application.PlaceDTO;
import com.eduardosoares.QueroSerClickbusBackend.BusinessRules.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceJPA extends JpaRepository<Place, Long> {

    @Query(value = "SELECT p from Place p WHERE p.slug = ?1")
    Optional<Place> findPlaceBySlug (String slug);

    @Query(value = "SELECT p FROM Place p WHERE p.name = ?1")
    List<Place> findPlacesByName (String name);
}
