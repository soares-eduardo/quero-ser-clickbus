package com.eduardosoares.QueroSerClickbusBackend.Application.UseCases;

import com.eduardosoares.QueroSerClickbusBackend.Application.PlaceDTO;
import com.eduardosoares.QueroSerClickbusBackend.BusinessRules.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletePlaceUC {

    @Autowired
    private PlaceService placeService;

    public PlaceDTO run(Long id) {
        return placeService.deletePlace(id);
    }
}
