package com.imb.progra3_3_2026.raza;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.imb.progra3_3_2026.especie.Especie;

@Component
public class RazaMapper {

    /**
     * Convierte un RazaRequestDTO a la entidad Raza.
     * Si se proporciona especieId, inicializa la entidad Especie asociada con su id.
     */
    public Raza toEntity(RazaRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Raza raza = new Raza();
        raza.setNombre(dto.getNombre());
        if (dto.getTamanioPromedio() != null) {
            raza.setTamanioPromedio(dto.getTamanioPromedio());
        }
        if (dto.getPesoPromedio() != null) {
            raza.setPesoPromedio(dto.getPesoPromedio());
        }
        raza.setObservaciones(dto.getObservaciones());

        if (dto.getEspecieId() != null) {
            Especie especie = new Especie();
            especie.setId(dto.getEspecieId());
            raza.setEspecie(especie);
        }

        return raza;
    }

    /**
     * Convierte la entidad Raza a un RazaResponseDTO.
     * Mapea la relación con Especie hacia el objeto anidado reducido EspecieDTO.
     */
    public RazaResponseDTO toResponseDTO(Raza raza) {
        if (raza == null) {
            return null;
        }

        RazaResponseDTO dto = new RazaResponseDTO();
        dto.setId(raza.getId());
        dto.setNombre(raza.getNombre());
        dto.setTamanioPromedio(raza.getTamanioPromedio());
        dto.setPesoPromedio(raza.getPesoPromedio());
        dto.setObservaciones(raza.getObservaciones());
        dto.setFechaCreacion(raza.getFechaCreacion());
        dto.setFechaActualizacion(raza.getFechaActualizacion());

        if (raza.getEspecie() != null) {
            RazaResponseDTO.EspecieDTO especieDTO = new RazaResponseDTO.EspecieDTO();
            especieDTO.setId(raza.getEspecie().getId());
            especieDTO.setNombre(raza.getEspecie().getNombre());
            especieDTO.setDescripcion(raza.getEspecie().getDescripcion());
            dto.setEspecie(especieDTO);
        }

        return dto;
    }

    /**
     * Convierte una lista de entidades Raza a una lista de RazaResponseDTO.
     */
    public List<RazaResponseDTO> toResponseDTOList(List<Raza> razas) {
        if (razas == null) {
            return Collections.emptyList();
        }
        return razas.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
