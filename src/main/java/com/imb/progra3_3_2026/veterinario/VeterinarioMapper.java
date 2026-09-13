package com.imb.progra3_3_2026.veterinario;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.imb.progra3_3_2026.especialidad.Especialidad;

@Component
public class VeterinarioMapper {

    /**
     * Convierte de VeterinarioRequestDTO a la entidad Veterinario.
     * Mapea los atributos directos y la relación JPA mediante el ID de Especialidad.
     *
     * @param dto Datos recibidos desde la petición.
     * @return Entidad Veterinario con sus atributos asignados.
     */
    public Veterinario toEntity(VeterinarioRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Veterinario veterinario = new Veterinario();
        veterinario.setNombre(dto.getNombre());
        veterinario.setApellido(dto.getApellido());
        veterinario.setMatricula(dto.getMatricula());
        veterinario.setTelefono(dto.getTelefono());
        veterinario.setEmail(dto.getEmail());

        if (dto.getEspecialidadId() != null) {
            Especialidad especialidad = new Especialidad();
            especialidad.setId(dto.getEspecialidadId());
            veterinario.setEspecialidad(especialidad);
        }

        return veterinario;
    }

    /**
     * Convierte de la entidad Veterinario a VeterinarioResponseDTO.
     * Mapea los atributos directos, los datos de auditoría de BaseEntity y la relación anidada de Especialidad.
     *
     * @param entity Entidad Veterinario persistida.
     * @return DTO de respuesta con la información completa.
     */
    public VeterinarioResponseDTO toResponseDTO(Veterinario entity) {
        if (entity == null) {
            return null;
        }

        VeterinarioResponseDTO dto = new VeterinarioResponseDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setMatricula(entity.getMatricula());
        dto.setTelefono(entity.getTelefono());
        dto.setEmail(entity.getEmail());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaActualizacion(entity.getFechaActualizacion());

        if (entity.getEspecialidad() != null) {
            VeterinarioResponseDTO.EspecialidadDTO especialidadDTO = new VeterinarioResponseDTO.EspecialidadDTO();
            especialidadDTO.setId(entity.getEspecialidad().getId());
            especialidadDTO.setNombre(entity.getEspecialidad().getNombre());
            especialidadDTO.setDescripcion(entity.getEspecialidad().getDescripcion());
            dto.setEspecialidad(especialidadDTO);
        }

        return dto;
    }

    /**
     * Sobrecarga de conveniencia para toResponseDTO.
     *
     * @param entity Entidad Veterinario.
     * @return DTO de respuesta.
     */
    public VeterinarioResponseDTO toDTO(Veterinario entity) {
        return toResponseDTO(entity);
    }

    /**
     * Convierte una lista de entidades Veterinario a una lista de VeterinarioResponseDTO.
     *
     * @param entities Lista de entidades Veterinario.
     * @return Lista de VeterinarioResponseDTO.
     */
    public List<VeterinarioResponseDTO> toResponseDTOList(List<Veterinario> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }

        return entities.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
