package com.eduardosoares.QueroSerClickbusBackend.Application.UseCases;

import com.eduardosoares.QueroSerClickbusBackend.Application.PlaceDTO;
import com.eduardosoares.QueroSerClickbusBackend.BusinessRules.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPlaceBySlugUC {

    @Autowired
    private PlaceService placeService;

    public PlaceDTO run(String slug) {
        return placeService.getPlaceBySlug(slug);
    }
}
