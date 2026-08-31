package com.imb.progra3_3_2026.aplicacionvacuna;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AplicacionVacunaRepository extends JpaRepository<AplicacionVacuna, Long> {
}