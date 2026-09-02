package com.imb.progra3_3_2026.diagnostico;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.imb.progra3_3_2026.consulta.Consulta;

@Component
public class DiagnosticoMapper {

    public Diagnostico toEntity(DiagnosticoRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setDescripcion(dto.getDescripcion());
        diagnostico.setGravedad(dto.getGravedad());
        diagnostico.setFechaDeteccion(dto.getFechaDeteccion());
        diagnostico.setObservaciones(dto.getObservaciones());

        if (dto.getConsultaId() != null) {
            Consulta consulta = new Consulta();
            consulta.setId(dto.getConsultaId());
            diagnostico.setConsulta(consulta);
        }

        return diagnostico;
    }

    public DiagnosticoResponseDTO toResponseDTO(Diagnostico entity) {
        if (entity == null) {
            return null;
        }

        DiagnosticoResponseDTO dto = new DiagnosticoResponseDTO();
        dto.setId(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
        dto.setGravedad(entity.getGravedad());
        dto.setFechaDeteccion(entity.getFechaDeteccion());
        dto.setObservaciones(entity.getObservaciones());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaActualizacion(entity.getFechaActualizacion());

        if (entity.getConsulta() != null) {
            DiagnosticoResponseDTO.ConsultaDTO consultaDTO = new DiagnosticoResponseDTO.ConsultaDTO(
                entity.getConsulta().getId(),
                entity.getConsulta().getFecha(),
                entity.getConsulta().getMotivo()
            );
            dto.setConsulta(consultaDTO);
        }

        return dto;
    }

    public List<DiagnosticoResponseDTO> toResponseDTOList(List<Diagnostico> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(this::toResponseDTO)
                .toList();
    }
}
