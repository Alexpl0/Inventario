package com.inventario.inventario.Salas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalasRepository extends JpaRepository<Salas, Long> {
    
} 
