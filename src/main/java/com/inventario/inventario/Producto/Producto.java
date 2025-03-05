package com.inventario.inventario.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.inventario.inventario.Categoria.Categoria;
import com.inventario.inventario.Ubicacion.Ubicacion;

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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ubicacion_id")
    private Ubicacion ubicacion;


    //Sirve para que el producto pueda tener una categoria
    @JsonBackReference
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;


    
    //@OneToMany(mappedBy = "productos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //private Categoria categorias;
    
    
    /*
    //Sirve para que el producto pueda tener una categoria
    // Define un campo privado para almacenar el ID de la categoría del producto
    private Long categoriaId;

    // Método getter para obtener el ID de la categoría del producto
    public Long getCategoriaId() {
        return categoriaId;
    }

    // Método setter para establecer el ID de la categoría del producto
    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    // Define un campo privado para almacenar el ID de la ubicación del producto
    private Long ubicacionId;

    // Método getter para obtener el ID de la ubicación del producto
    public Long getUbicacionId() {
        return ubicacionId;
    }

    // Método setter para establecer el ID de la ubicación del producto
    public void setUbicacionId(Long ubicacionId) {
        this.ubicacionId = ubicacionId;
    }
        */
}

