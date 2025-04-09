package com.inventario.inventario.Ubicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.inventario.inventario.Producto.Producto;

@Entity
@Table(name = "ubicaciones")
@Getter
@Setter
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "ubicacion")
    private Set<Producto> productos;
}
