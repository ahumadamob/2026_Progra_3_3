package com.imb.progra3_3_2026.turno;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TurnoMapper {

    public TurnoResponseDTO toResponseDTO(Turno turno) {
        if (turno == null) {
            return null;
        }
        return new TurnoResponseDTO(turno);
    }

    public List<TurnoResponseDTO> toResponseDTOList(List<Turno> turnos) {
        if (turnos == null || turnos.isEmpty()) {
            return Collections.emptyList();
        }
        return turnos.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public Turno toEntity(TurnoRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }
        return requestDTO.toTurno();
    }
}
