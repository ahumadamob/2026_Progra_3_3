package com.imb.progra3_3_2026.veterinario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb.progra3_3_2026.especialidad.Especialidad;
import com.imb.progra3_3_2026.especialidad.EspecialidadRepository;
import com.imb.progra3_3_2026.exceptions.ResourceNotFoundException;

@Service
public class VeterinarioService {

	@Autowired
	private VeterinarioRepository repo;

	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	public List<Veterinario> getAll() {
		return repo.findAll();
	}
	
	public Veterinario getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Veterinario create(Veterinario veterinario) {
		resolverEspecialidad(veterinario);
		return repo.save(veterinario);
	}
	
	public Veterinario update(Long id, Veterinario veterinario) {
		Veterinario actualizarVeterinario = this.getById(id);
		if (actualizarVeterinario == null) {
			return null;
		} else {
			veterinario.setId(id);
			resolverEspecialidad(veterinario);
			return repo.save(veterinario);
		}
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	/**
	 * Si el veterinario contiene una Especialidad, recupera la entidad completa
	 * desde EspecialidadRepository. Si no existe, lanza ResourceNotFoundException
	 * y recién entonces la asigna a la entidad.
	 */
	private void resolverEspecialidad(Veterinario veterinario) {
		if (veterinario.getEspecialidad() != null) {
			Long especialidadId = veterinario.getEspecialidad().getId();
			if (especialidadId == null) {
				throw new ResourceNotFoundException("Especialidad no encontrada");
			}
			Especialidad especialidad = especialidadRepository.findById(especialidadId)
					.orElseThrow(() -> new ResourceNotFoundException(
							"Especialidad no encontrada con id: " + especialidadId));
			veterinario.setEspecialidad(especialidad);
		}
	}
}

