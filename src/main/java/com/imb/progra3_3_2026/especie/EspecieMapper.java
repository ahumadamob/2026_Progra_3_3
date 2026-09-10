package com.imb.progra3_3_2026.especie;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class EspecieMapper {

    public Especie toEntity(EspecieRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Especie especie = new Especie();
        especie.setNombre(dto.getNombre());
        especie.setDescripcion(dto.getDescripcion());
        especie.setRequiereVacunacion(dto.isRequiereVacunacion());
        especie.setExpectativaVida(dto.getExpectativaVida());

        return especie;
    }

    public EspecieResponseDTO toResponseDTO(Especie entity) {
        if (entity == null) {
            return null;
        }

        EspecieResponseDTO dto = new EspecieResponseDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setRequiereVacunacion(entity.isRequiereVacunacion());
        dto.setExpectativaVida(entity.getExpectativaVida());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaActualizacion(entity.getFechaActualizacion());

        return dto;
    }

    public List<EspecieResponseDTO> toResponseDTOList(List<Especie> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }

        return entities.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public void updateEntity(Especie entity, EspecieRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setRequiereVacunacion(dto.isRequiereVacunacion());
        entity.setExpectativaVida(dto.getExpectativaVida());
    }
}
