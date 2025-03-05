package com.inventario.inventario.Ubicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.inventario.inventario.Producto.Producto;

@Entity
@Table(name = "ubicaciones")
@Getter
@Setter
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @JsonManagedReference
    @OneToMany(mappedBy = "ubicacion")
    private Set<Producto> productos;
}
