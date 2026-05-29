package com.imb.progra3_3_2026.insumoClinico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsumoClinicoRepository extends JpaRepository<InsumoClinico, Long> {

}
