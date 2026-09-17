package com.imb.progra3_3_2026.raza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb.progra3_3_2026.especie.Especie;
import com.imb.progra3_3_2026.especie.EspecieRepository;
import com.imb.progra3_3_2026.exceptions.ResourceNotFoundException;

@Service
public class RazaService {

	@Autowired
	private RazaRepository repo;

	@Autowired
	private EspecieRepository especieRepository;

	public List<Raza> getAll() {
		return repo.findAll();
	}

	public Raza getById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public Raza create(Raza raza) {
		asociarEspecie(raza);
		return repo.save(raza);
	}

	public Raza update(Long id, Raza raza) {
		Raza actualizarRaza = this.getById(id);
		if (actualizarRaza == null) {
			return null;
		} else {
			asociarEspecie(raza);
			raza.setId(id);
			return repo.save(raza);
		}
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	private void asociarEspecie(Raza raza) {
		if (raza.getEspecie() == null || raza.getEspecie().getId() == null) {
			throw new ResourceNotFoundException("Debe proporcionar un ID de especie válido.");
		}
		Long especieId = raza.getEspecie().getId();
		Especie especie = especieRepository.findById(especieId)
				.orElseThrow(() -> new ResourceNotFoundException("Especie no encontrada con id: " + especieId));
		raza.setEspecie(especie);
	}

}

