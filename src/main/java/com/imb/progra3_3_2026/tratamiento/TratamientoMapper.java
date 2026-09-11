package com.imb.progra3_3_2026.tratamiento;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.imb.progra3_3_2026.diagnostico.Diagnostico;

@Component
public class TratamientoMapper {

    public Tratamiento toEntity(TratamientoRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setFechaInicio(dto.getFechaInicio());
        tratamiento.setFechaFinEstimada(dto.getFechaFinEstimada());
        tratamiento.setDescripcion(dto.getDescripcion());
        tratamiento.setIndicaciones(dto.getIndicaciones());

        if (dto.getDiagnosticoId() != null) {
            Diagnostico diagnostico = new Diagnostico();
            diagnostico.setId(dto.getDiagnosticoId());
            tratamiento.setDiagnostico(diagnostico);
        }

        return tratamiento;
    }

    public TratamientoResponseDTO toResponseDTO(Tratamiento entity) {
        if (entity == null) {
            return null;
        }

        TratamientoResponseDTO dto = new TratamientoResponseDTO();
        dto.setId(entity.getId());
        dto.setFechaInicio(entity.getFechaInicio());
        dto.setFechaFinEstimada(entity.getFechaFinEstimada());
        dto.setDescripcion(entity.getDescripcion());
        dto.setIndicaciones(entity.getIndicaciones());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaActualizacion(entity.getFechaActualizacion());

        if (entity.getDiagnostico() != null) {
            TratamientoResponseDTO.DiagnosticoDTO diagnosticoDTO = new TratamientoResponseDTO.DiagnosticoDTO(
                entity.getDiagnostico().getId(),
                entity.getDiagnostico().getDescripcion(),
                entity.getDiagnostico().getGravedad()
            );
            dto.setDiagnostico(diagnosticoDTO);
        }

        return dto;
    }

    public List<TratamientoResponseDTO> toResponseDTOList(List<Tratamiento> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(this::toResponseDTO)
                .toList();
    }
}
