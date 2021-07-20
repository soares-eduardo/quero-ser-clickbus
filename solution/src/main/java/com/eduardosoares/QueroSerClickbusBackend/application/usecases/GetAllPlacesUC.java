package com.eduardosoares.QueroSerClickbusBackend.application.usecases;

import com.eduardosoares.QueroSerClickbusBackend.application.PlaceDTO;
import com.eduardosoares.QueroSerClickbusBackend.business.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllPlacesUC {

    @Autowired
    private PlaceService placeService;

    public List<PlaceDTO> run() {
        return placeService.getAllPlaces();
    }
}
