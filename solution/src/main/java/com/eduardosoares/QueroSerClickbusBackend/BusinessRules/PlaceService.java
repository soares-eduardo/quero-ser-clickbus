package com.eduardosoares.QueroSerClickbusBackend.BusinessRules;

import com.eduardosoares.QueroSerClickbusBackend.Application.PlaceDTO;
import com.eduardosoares.QueroSerClickbusBackend.BusinessRules.Exceptions.NotFoundException;
import com.eduardosoares.QueroSerClickbusBackend.Utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        return placeRepository.findPlaceBySlug(slug).map(placeMapper::toDto).orElseThrow(() -> new NotFoundException(MessageUtils.PLACE_NOT_FOUND));
    }

    public List<PlaceDTO> getPlacesByName(String name) {
        List<PlaceDTO> placeList = placeRepository.findPlacesByName(name).stream().map(placeMapper::toDto).collect(Collectors.toList());

        if (placeList.isEmpty()) {
            throw new NotFoundException(MessageUtils.NO_RECORDS_FOUND);
        }

        return placeList;
    }

    public PlaceDTO registerNewPlace(PlaceDTO body) {
        Place place = placeRepository.insertPlace(placeMapper.toEntity(body));
        return placeMapper.toDto(place);
    }

    @Transactional
    public PlaceDTO updatePlace(Long id, String name, String city, String state) {

       Place place = placeRepository.findPlaceById(id).
               orElseThrow(() -> new NotFoundException(MessageUtils.PLACE_NOT_FOUND));

       if (name != null && name.length() > 0) {
           place.setName(name);
       }

       if (city != null && city.length() > 0) {
           place.setCity(city);
       }

       if (state != null && state.length() > 0) {
           place.setState(state);
       }

       return placeMapper.toDto(place);
    }

    public PlaceDTO deletePlace(Long id) {
        PlaceDTO placeDTO = this.findPlaceById(id);
        placeRepository.deleteById(placeDTO.getId());

        return placeDTO;
    }

    public PlaceDTO findPlaceById(Long id) {
        return placeRepository.findPlaceById(id).map(placeMapper::toDto).orElseThrow(() -> new NotFoundException(MessageUtils.PLACE_NOT_FOUND));
    }
}
