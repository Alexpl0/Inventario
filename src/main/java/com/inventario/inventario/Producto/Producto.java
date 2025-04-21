package com.inventario.inventario.Producto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.inventario.inventario.Categoria.Categoria;
import com.inventario.inventario.Ubicacion.Ubicacion;
import com.inventario.inventario.InvtentarioGeneral.Inventario;

@Entity
@Table(name = "productos")
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private double precio;

    @Column(name = "fecha")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    
    @ManyToOne
    @JoinColumn(name = "ubicacion_id") // Muchos productos pueden estar en una ubicación
    private Ubicacion ubicacion;

    @ManyToOne
    @JoinColumn(name = "categoria_id") // Muchos productos pueden tener una categoría
    private Categoria categoria;

    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Inventario> inventarios; // Un producto puede tener múltiples entradas de inventario
}

