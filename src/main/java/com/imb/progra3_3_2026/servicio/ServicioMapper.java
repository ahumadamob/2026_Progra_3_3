package com.imb.progra3_3_2026.servicio;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ServicioMapper {

    public Servicio toEntity(ServicioRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Servicio servicio = new Servicio();
        servicio.setNombre(dto.getNombre());
        servicio.setDescripcion(dto.getDescripcion());
        servicio.setPrecioBase(dto.getPrecioBase());
        servicio.setDuracionEstimadaMinutos(dto.getDuracionEstimadaMinutos());
        servicio.setRequiereTurno(dto.isRequiereTurno());

        return servicio;
    }

    public ServicioResponseDTO toResponseDTO(Servicio entity) {
        if (entity == null) {
            return null;
        }

        ServicioResponseDTO dto = new ServicioResponseDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setPrecioBase(entity.getPrecioBase());
        dto.setDuracionEstimadaMinutos(entity.getDuracionEstimadaMinutos());
        dto.setRequiereTurno(entity.isRequiereTurno());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaActualizacion(entity.getFechaActualizacion());

        return dto;
    }

    public List<ServicioResponseDTO> toResponseDTOList(List<Servicio> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(this::toResponseDTO)
                .toList();
    }
}
