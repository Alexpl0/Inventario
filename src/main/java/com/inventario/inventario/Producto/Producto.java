package com.inventario.inventario.Producto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.inventario.inventario.Categoria.Categoria;
import com.inventario.inventario.Ubicacion.Ubicacion;

@Entity
@Table(name = "productos")
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")

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

 
    @ManyToOne  
    @JoinColumn(name = "ubicacion_id")
    private Ubicacion ubicacion;


    //Sirve para que el producto pueda tener una categoria
    //@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}

