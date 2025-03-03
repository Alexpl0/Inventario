package com.inventario.inventario.InvtentarioGeneral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    
}
