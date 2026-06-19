package com.imb.progra3_3_2026.vacuna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacunaService {

    @Autowired
    private VacunaRepository vacunaRepository;

    public List<Vacuna> getAll() {
        return vacunaRepository.findAll();
    }

    public Optional<Vacuna> getById(Long id) {
        return vacunaRepository.findById(id);
    }

    public Vacuna create(Vacuna vacuna) {
        return vacunaRepository.save(vacuna);
    }

    public Vacuna update(Long id, Vacuna vacunaActualizada) {

        Optional<Vacuna> vacunaExistente = vacunaRepository.findById(id);

        if (vacunaExistente.isPresent()) {

            Vacuna vacuna = vacunaExistente.get();

            vacuna.setNombre(vacunaActualizada.getNombre());
            vacuna.setEspecie(vacunaActualizada.getEspecie());
            vacuna.setLaboratorio(vacunaActualizada.getLaboratorio());
            vacuna.setEdadRecomendadaMeses(vacunaActualizada.getEdadRecomendadaMeses());
            vacuna.setRefuerzoAnual(vacunaActualizada.getRefuerzoAnual());

            return vacunaRepository.save(vacuna);
        }

        return null;
    }

    public void delete(Long id) {
        vacunaRepository.deleteById(id);
    }
}