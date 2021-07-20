package com.eduardosoares.QueroSerClickbusBackend.application.usecases;

import com.eduardosoares.QueroSerClickbusBackend.application.PlaceDTO;
import com.eduardosoares.QueroSerClickbusBackend.business.PlaceService;
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
