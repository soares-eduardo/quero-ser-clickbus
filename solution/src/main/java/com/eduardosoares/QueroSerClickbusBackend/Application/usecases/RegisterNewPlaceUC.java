package com.eduardosoares.QueroSerClickbusBackend.Application.usecases;

import com.eduardosoares.QueroSerClickbusBackend.Application.PlaceDTO;
import com.eduardosoares.QueroSerClickbusBackend.BusinessRules.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterNewPlaceUC {

    @Autowired
    private PlaceService placeService;

    public PlaceDTO run(PlaceDTO body) {
        return placeService.registerNewPlace(body);
    }
}
