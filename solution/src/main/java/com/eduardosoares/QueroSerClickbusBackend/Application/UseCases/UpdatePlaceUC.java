package com.eduardosoares.QueroSerClickbusBackend.Application.UseCases;

import com.eduardosoares.QueroSerClickbusBackend.Application.PlaceDTO;
import com.eduardosoares.QueroSerClickbusBackend.BusinessRules.PlaceService;
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
