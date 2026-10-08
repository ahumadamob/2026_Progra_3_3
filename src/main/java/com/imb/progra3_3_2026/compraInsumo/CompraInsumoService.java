package com.imb.progra3_3_2026.compraInsumo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imb.progra3_3_2026.exceptions.ResourceNotFoundException;
import com.imb.progra3_3_2026.insumoClinico.InsumoClinico;
import com.imb.progra3_3_2026.insumoClinico.InsumoClinicoRepository;
import com.imb.progra3_3_2026.proveedor.Proveedor;
import com.imb.progra3_3_2026.proveedor.ProveedorRepository;

@Service
public class CompraInsumoService {

	@Autowired
	private CompraInsumoRepository repo;

	@Autowired
	private ProveedorRepository proveedorRepository;

	@Autowired
	private InsumoClinicoRepository insumoClinicoRepository;

	public List<CompraInsumo> getAll() {
		return repo.findAll();
	}

	public CompraInsumo getById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public CompraInsumo create(CompraInsumo compraInsumo) {
		Proveedor proveedor = proveedorRepository.findById(compraInsumo.getProveedor().getId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"Proveedor no encontrado con id: " + compraInsumo.getProveedor().getId()));

		InsumoClinico insumoClinico = insumoClinicoRepository.findById(compraInsumo.getInsumoClinico().getId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"InsumoClinico no encontrado con id: " + compraInsumo.getInsumoClinico().getId()));

		compraInsumo.setProveedor(proveedor);
		compraInsumo.setInsumoClinico(insumoClinico);
		return repo.save(compraInsumo);
	}

	public CompraInsumo update(CompraInsumo compraInsumo, Long id) {
		CompraInsumo actualizarCompraInsumo = this.getById(id);
		if (actualizarCompraInsumo == null) {
			return null;
		} else {
			Proveedor proveedor = proveedorRepository.findById(compraInsumo.getProveedor().getId())
					.orElseThrow(() -> new ResourceNotFoundException(
							"Proveedor no encontrado con id: " + compraInsumo.getProveedor().getId()));

			InsumoClinico insumoClinico = insumoClinicoRepository.findById(compraInsumo.getInsumoClinico().getId())
					.orElseThrow(() -> new ResourceNotFoundException(
							"InsumoClinico no encontrado con id: " + compraInsumo.getInsumoClinico().getId()));

			compraInsumo.setId(id);
			compraInsumo.setProveedor(proveedor);
			compraInsumo.setInsumoClinico(insumoClinico);
			return repo.save(compraInsumo);
		}
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

}