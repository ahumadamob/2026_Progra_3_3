package com.imb.progra3_3_2026.medicamento;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class MedicamentoMapper {

    /**
     * Convierte un MedicamentoRequestDTO a la entidad Medicamento.
     *
     * @param requestDTO Datos enviados por el cliente.
     * @return Entidad Medicamento mapeada o null si el DTO es nulo.
     */
    public Medicamento toEntity(MedicamentoRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }

        Medicamento medicamento = new Medicamento();
        medicamento.setNombre(requestDTO.getNombre());
        medicamento.setLaboratorio(requestDTO.getLaboratorio());
        medicamento.setPresentacion(requestDTO.getPresentacion());
        medicamento.setDosisRecomendada(requestDTO.getDosisRecomendada());
        medicamento.setRequiereReceta(requestDTO.getRequiereReceta());

        return medicamento;
    }

    /**
     * Convierte la entidad Medicamento a MedicamentoResponseDTO.
     *
     * @param medicamento Entidad proveniente de la base de datos o servicio.
     * @return DTO de respuesta con los datos formateados o null si la entidad es nula.
     */
    public MedicamentoResponseDTO toResponseDTO(Medicamento medicamento) {
        if (medicamento == null) {
            return null;
        }

        MedicamentoResponseDTO responseDTO = new MedicamentoResponseDTO();
        responseDTO.setId(medicamento.getId());
        responseDTO.setNombre(medicamento.getNombre());
        responseDTO.setLaboratorio(medicamento.getLaboratorio());
        responseDTO.setPresentacion(medicamento.getPresentacion());
        responseDTO.setDosisRecomendada(medicamento.getDosisRecomendada());
        responseDTO.setRequiereReceta(medicamento.getRequiereReceta());
        responseDTO.setFechaCreacion(medicamento.getFechaCreacion());
        responseDTO.setFechaActualizacion(medicamento.getFechaActualizacion());

        return responseDTO;
    }

    /**
     * Actualiza una entidad Medicamento existente a partir de un MedicamentoRequestDTO.
     *
     * @param medicamento Entidad a actualizar.
     * @param requestDTO  Nuevos datos.
     */
    public void updateEntity(Medicamento medicamento, MedicamentoRequestDTO requestDTO) {
        if (medicamento == null || requestDTO == null) {
            return;
        }

        medicamento.setNombre(requestDTO.getNombre());
        medicamento.setLaboratorio(requestDTO.getLaboratorio());
        medicamento.setPresentacion(requestDTO.getPresentacion());
        medicamento.setDosisRecomendada(requestDTO.getDosisRecomendada());
        medicamento.setRequiereReceta(requestDTO.getRequiereReceta());
    }

    /**
     * Convierte una lista de entidades Medicamento a una lista de MedicamentoResponseDTO.
     *
     * @param medicamentos Lista de entidades.
     * @return Lista de ResponseDTOs correspondientes.
     */
    public List<MedicamentoResponseDTO> toResponseDTOList(List<Medicamento> medicamentos) {
        if (medicamentos == null) {
            return Collections.emptyList();
        }

        return medicamentos.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
