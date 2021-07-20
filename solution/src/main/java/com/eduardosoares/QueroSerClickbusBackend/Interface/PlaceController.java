package com.eduardosoares.QueroSerClickbusBackend.Interface;

import com.eduardosoares.QueroSerClickbusBackend.Application.PlaceDTO;
import com.eduardosoares.QueroSerClickbusBackend.Application.UseCases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/place")
public class PlaceController {

    @Autowired
    private GetAllPlacesUC getAllPlacesUC;

    @Autowired
    private GetPlaceBySlugUC getPlaceBySlugUC;

    @Autowired
    private GetPlacesByNameUC getPlacesByNameUC;

    @Autowired
    private RegisterNewPlaceUC registerNewPlaceUC;

    @Autowired
    private UpdatePlaceUC updatePlaceUC;

    @Autowired
    private DeletePlaceUC deletePlaceUC;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlaceDTO>> getAllPlaces() {
        return ResponseEntity.ok(getAllPlacesUC.run());
    }

    @GetMapping(path = "/{slug}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDTO> getPlaceBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(getPlaceBySlugUC.run(slug));
    }

    @GetMapping(path = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlaceDTO>> getPlacesByName(@PathVariable String name) {
        return ResponseEntity.ok(getPlacesByNameUC.run(name));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDTO> registerNewPlace(@Valid @RequestBody PlaceDTO body) {
        return ResponseEntity.ok(registerNewPlaceUC.run(body));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDTO> updatePlace(@PathVariable(value = "id") Long id,
                                                @RequestParam(required = false) String name,
                                                @RequestParam(required = false) String city,
                                                @RequestParam(required = false) String state) {
        return ResponseEntity.ok(updatePlaceUC.run(id, name, city, state));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDTO> deletePlace(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(deletePlaceUC.run(id));
    }
}
