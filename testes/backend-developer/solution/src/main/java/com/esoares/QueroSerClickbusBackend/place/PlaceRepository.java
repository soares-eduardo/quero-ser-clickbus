package com.esoares.QueroSerClickbusBackend.place;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    //TODO Create a business logic to not allow places already registered

}
