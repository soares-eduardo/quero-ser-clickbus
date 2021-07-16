package com.eduardosoares.QueroSerClickbusBackend.Application.UseCases;

import com.eduardosoares.QueroSerClickbusBackend.Application.PlaceDTO;
import com.eduardosoares.QueroSerClickbusBackend.BusinessRules.PlaceService;
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
