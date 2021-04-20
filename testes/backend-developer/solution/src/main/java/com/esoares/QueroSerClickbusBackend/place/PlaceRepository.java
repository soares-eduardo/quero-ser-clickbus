package com.esoares.QueroSerClickbusBackend.place;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query(value = "SELECT p FROM Place p WHERE p.name = ?1")
    List<Place> findPlaceByName (String name);

}
 