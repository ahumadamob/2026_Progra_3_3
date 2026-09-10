package com.imb.progra3_3_2026.especialidad;

import org.springframework.stereotype.Component;

@Component
public class EspecialidadMapper {

    /**
     * Convierte un RequestDTO a una entidad Especialidad nueva.
     * No asigna id, fechaCreacion ni fechaActualizacion; esos los gestiona JPA.
     */
    public Especialidad toEntity(EspecialidadRequestDTO dto) {
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre(dto.getNombre());
        especialidad.setDescripcion(dto.getDescripcion());
        especialidad.setAreaClinica(dto.getAreaClinica());
        especialidad.setRequiereMatriculaEspecial(dto.getRequiereMatriculaEspecial());
        return especialidad;
    }

    /**
     * Aplica los datos de un RequestDTO sobre una entidad ya existente.
     * Útil para operaciones PUT/PATCH sin reemplazar el objeto persistido.
     */
    public void updateEntity(EspecialidadRequestDTO dto, Especialidad especialidad) {
        especialidad.setNombre(dto.getNombre());
        especialidad.setDescripcion(dto.getDescripcion());
        especialidad.setAreaClinica(dto.getAreaClinica());
        especialidad.setRequiereMatriculaEspecial(dto.getRequiereMatriculaEspecial());
    }

    /**
     * Convierte una entidad Especialidad a su ResponseDTO.
     */
    public EspecialidadResponseDTO toResponseDTO(Especialidad especialidad) {
        return new EspecialidadResponseDTO(especialidad);
    }
}
