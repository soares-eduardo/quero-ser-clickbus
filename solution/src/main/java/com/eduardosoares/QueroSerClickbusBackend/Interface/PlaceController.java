package com.eduardosoares.QueroSerClickbusBackend.Interface;

import com.eduardosoares.QueroSerClickbusBackend.Application.PlaceDTO;
import com.eduardosoares.QueroSerClickbusBackend.Application.UseCases.GetAllPlacesUC;
import com.eduardosoares.QueroSerClickbusBackend.Application.UseCases.GetPlaceBySlugUC;
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlaceDTO>> getAllPlaces() {
        return ResponseEntity.ok(getAllPlacesUC.run());
    }

    @GetMapping(path = "/{slug}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDTO> getPlaceBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(getPlaceBySlugUC.run(slug));
    }

    @GetMapping(path = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDTO> getPlacesByName(@PathVariable String name) {
        return ResponseEntity.ok(null);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDTO> registerNewPlace(@Valid @RequestBody PlaceDTO body) {
        return ResponseEntity.ok(body);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDTO> updatePlace(@Valid @RequestBody PlaceDTO body) {
        return ResponseEntity.ok(body);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDTO> deletePlace(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(null);
    }
}
