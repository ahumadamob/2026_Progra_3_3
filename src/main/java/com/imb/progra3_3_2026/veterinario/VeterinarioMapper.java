package com.imb.progra3_3_2026.veterinario;

import org.springframework.stereotype.Component;

import com.imb.progra3_3_2026.especialidad.Especialidad;

@Component
public class VeterinarioMapper {

    /**
     * Convierte un VeterinarioRequestDTO a la entidad Veterinario.
     * No incluye id ni fechas de auditoría ya que son gestionadas por BaseEntity y la base de datos.
     * Si se envía especialidadId, se vincula mediante una instancia de Especialidad con dicho identificador.
     */
    public Veterinario toEntity(VeterinarioRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }

        Veterinario veterinario = new Veterinario();
        veterinario.setNombre(requestDTO.getNombre());
        veterinario.setApellido(requestDTO.getApellido());
        veterinario.setMatricula(requestDTO.getMatricula());
        veterinario.setTelefono(requestDTO.getTelefono());
        veterinario.setEmail(requestDTO.getEmail());

        if (requestDTO.getEspecialidadId() != null) {
            Especialidad especialidad = new Especialidad();
            especialidad.setId(requestDTO.getEspecialidadId());
            veterinario.setEspecialidad(especialidad);
        }

        return veterinario;
    }

    /**
     * Convierte una entidad Veterinario a un VeterinarioResponseDTO.
     * Incluye datos propios, atributos heredados de BaseEntity y la relación anidada con Especialidad.
     */
    public VeterinarioResponseDTO toResponseDTO(Veterinario veterinario) {
        if (veterinario == null) {
            return null;
        }

        VeterinarioResponseDTO responseDTO = new VeterinarioResponseDTO();
        responseDTO.setId(veterinario.getId());
        responseDTO.setNombre(veterinario.getNombre());
        responseDTO.setApellido(veterinario.getApellido());
        responseDTO.setMatricula(veterinario.getMatricula());
        responseDTO.setTelefono(veterinario.getTelefono());
        responseDTO.setEmail(veterinario.getEmail());
        responseDTO.setFechaCreacion(veterinario.getFechaCreacion());
        responseDTO.setFechaActualizacion(veterinario.getFechaActualizacion());

        if (veterinario.getEspecialidad() != null) {
            Especialidad especialidad = veterinario.getEspecialidad();
            EspecialidadResumenDTO resumenDTO = new EspecialidadResumenDTO(
                    especialidad.getId(),
                    especialidad.getNombre(),
                    especialidad.getDescripcion()
            );
            responseDTO.setEspecialidad(resumenDTO);
        }

        return responseDTO;
    }
}
