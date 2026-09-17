package com.imb.progra3_3_2026.vacuna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VacunaService {

    @Autowired
    private VacunaRepository vacunaRepository;

    public List<Vacuna> getAll() {
        return vacunaRepository.findAll();
    }

    public Vacuna getById(Long id) {
		return vacunaRepository.findById(id).orElse(null);
	}

    public Vacuna update(Vacuna vacuna,Long id) {
		Vacuna vacuna1 = this.getById(id);
		if(vacuna1 == null) {
			return null;
		}else{
		vacuna1.setId(id);
		return vacunaRepository.save(vacuna1);
		}
	}
    
    public Vacuna create(Vacuna vacuna) {
        return vacunaRepository.save(vacuna);
    }



    public void delete(Long id) {
        vacunaRepository.deleteById(id);
    }
}