package com.eduardosoares.QueroSerClickbusBackend.application.usecases;

import com.eduardosoares.QueroSerClickbusBackend.application.PlaceDTO;
import com.eduardosoares.QueroSerClickbusBackend.business_rules.PlaceService;
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
