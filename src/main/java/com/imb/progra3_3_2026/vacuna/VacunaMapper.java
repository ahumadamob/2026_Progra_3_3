package com.imb.progra3_3_2026.vacuna;

import com.imb.progra3_3_2026.especie.Especie;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class VacunaMapper {

    /**
     * Convierte un VacunaRequestDTO a la entidad Vacuna.
     * Mapea los atributos directos y la relación JPA mediante el ID de Especie.
     *
     * @param dto Datos recibidos desde la petición.
     * @return Entidad Vacuna con los atributos asignados.
     */
    public Vacuna toEntity(VacunaRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Vacuna vacuna = new Vacuna();
        vacuna.setNombre(dto.getNombre());
        vacuna.setLaboratorio(dto.getLaboratorio());
        vacuna.setEdadRecomendadaMeses(dto.getEdadRecomendadaMeses());
        vacuna.setRefuerzoAnual(dto.getRefuerzoAnual());

        if (dto.getEspecieId() != null) {
            Especie especie = new Especie();
            especie.setId(dto.getEspecieId());
            vacuna.setEspecie(especie);
        }

        return vacuna;
    }

    /**
     * Convierte una entidad Vacuna a VacunaResponseDTO.
     * Mapea los atributos directos, auditoría y el objeto reducido de Especie.
     *
     * @param entity Entidad Vacuna recuperada de persistencia.
     * @return DTO de respuesta con la información completa y formateada.
     */
    public VacunaResponseDTO toResponseDTO(Vacuna entity) {
        if (entity == null) {
            return null;
        }

        VacunaResponseDTO dto = new VacunaResponseDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setLaboratorio(entity.getLaboratorio());
        dto.setEdadRecomendadaMeses(entity.getEdadRecomendadaMeses());
        dto.setRefuerzoAnual(entity.getRefuerzoAnual());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaActualizacion(entity.getFechaActualizacion());

        if (entity.getEspecie() != null) {
            VacunaResponseDTO.EspecieResponseDTO especieDTO = new VacunaResponseDTO.EspecieResponseDTO();
            especieDTO.setId(entity.getEspecie().getId());
            especieDTO.setNombre(entity.getEspecie().getNombre());
            especieDTO.setDescripcion(entity.getEspecie().getDescripcion());
            dto.setEspecie(especieDTO);
        }

        return dto;
    }

    /**
     * Convierte una lista de entidades Vacuna a una lista de VacunaResponseDTO.
     *
     * @param entities Lista de entidades Vacuna.
     * @return Lista de VacunaResponseDTO.
     */
    public List<VacunaResponseDTO> toResponseDTOList(List<Vacuna> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }

        return entities.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
