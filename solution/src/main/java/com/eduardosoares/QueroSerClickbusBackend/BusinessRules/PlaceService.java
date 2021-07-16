package com.eduardosoares.QueroSerClickbusBackend.BusinessRules;

import com.eduardosoares.QueroSerClickbusBackend.Application.PlaceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    @Autowired
    IPlaceRepository placeRepository;

    @Autowired
    PlaceMapper placeMapper;

    public List<PlaceDTO> getAllPlaces() {
        return placeMapper.toDto(placeRepository.findAllPlaces());
    }

    public PlaceDTO getPlaceBySlug(String slug) {
        return placeRepository.findPlaceBySlug(slug).map(placeMapper::toDto).orElseThrow();
    }
}
