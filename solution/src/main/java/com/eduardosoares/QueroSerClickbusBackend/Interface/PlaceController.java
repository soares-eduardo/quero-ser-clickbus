package com.eduardosoares.QueroSerClickbusBackend.Interface;

import com.eduardosoares.QueroSerClickbusBackend.Application.PlaceDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(value = "*")
@RequestMapping(value = "/place")
@RestController
public class PlaceController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDTO> getAllPlaces() {
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/{slug}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDTO> getPlaceBySlug(@PathVariable(value = "slug") String slug) {
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDTO> getPlacesByName(@PathVariable(value = "name") String city) {
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
