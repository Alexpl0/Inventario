package com.inventario.inventario.Reservaciones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservacionesRepository extends JpaRepository<Reservaciones, Long> {
    
}
