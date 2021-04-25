package com.esoares.QueroSerClickbusBackend.Interface;

import java.util.List;

import com.esoares.QueroSerClickbusBackend.BusinessLogic.Place;
import com.esoares.QueroSerClickbusBackend.BusinessLogic.PlaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/place")
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public List<Place> getPlaces() {
        return placeService.getPlaces();
    }

    @GetMapping(path = "/name/{placeName}")
    public List<Place> getPlacesByName(@PathVariable("placeName") String placeName) {
        return placeService.getPlacesByName(placeName);
    }

    @GetMapping(path = "{placeSlug}")
    public Place getPlaceBySlug(@PathVariable("placeSlug") String placeSlug) {
        return placeService.getPlaceBySlug(placeSlug);
    }

    @PostMapping
    public void registerNewPlace(@RequestBody Place place) {
        placeService.addNewPlace(place);
    }

    @DeleteMapping(path = "{placeId}")
    public void deletePlace(@PathVariable("placeId") Long placeId) {
        placeService.deletePlace(placeId);
    }

    @PutMapping(path = "{placeId}")
    public void updatePlace(@PathVariable("placeId") Long placeId, @RequestParam(required = false) String name,
            @RequestParam(required = false) String city, @RequestParam(required = false) String state) {
        placeService.updatePlace(placeId, name, city, state);
    }
}