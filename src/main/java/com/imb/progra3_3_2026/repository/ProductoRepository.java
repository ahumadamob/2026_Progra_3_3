package com.imb.progra3_3_2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.imb.progra3_3_2026.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
