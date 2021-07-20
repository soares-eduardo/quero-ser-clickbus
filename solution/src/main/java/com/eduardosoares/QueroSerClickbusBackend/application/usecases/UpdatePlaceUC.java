package com.eduardosoares.QueroSerClickbusBackend.application.usecases;

import com.eduardosoares.QueroSerClickbusBackend.application.PlaceDTO;
import com.eduardosoares.QueroSerClickbusBackend.business.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePlaceUC {

    @Autowired
    private PlaceService placeService;

    public PlaceDTO run(Long id, String name, String city, String state) {
        return placeService.updatePlace(id, name, city, state);
    }
}
