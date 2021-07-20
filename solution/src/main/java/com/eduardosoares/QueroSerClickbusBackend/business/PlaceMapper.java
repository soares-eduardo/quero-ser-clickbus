package com.eduardosoares.QueroSerClickbusBackend.business;

import com.eduardosoares.QueroSerClickbusBackend.application.PlaceDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlaceMapper {

    public Place toEntity(PlaceDTO dto) {

        Place placeEntity = new Place();

        placeEntity.setId(dto.getId());
        placeEntity.setName(dto.getName());
        placeEntity.setSlug(dto.getSlug());
        placeEntity.setCity(dto.getCity());
        placeEntity.setState(dto.getState());

        return placeEntity;
    }

    public PlaceDTO toDto(Place entity) {

        PlaceDTO placeDto = new PlaceDTO();

        placeDto.setId(entity.getId());
        placeDto.setName(entity.getName());
        placeDto.setSlug(entity.getSlug());
        placeDto.setCity(entity.getCity());
        placeDto.setState(entity.getState());

        return placeDto;
    }

    public List<PlaceDTO> toDto(List<Place> placeList) {
        return placeList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
