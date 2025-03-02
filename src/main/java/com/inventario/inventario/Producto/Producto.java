package com.inventario.inventario.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import com.inventario.inventario.Categoria.Categoria;
import com.inventario.inventario.Ubicacion.Ubicacion;

@Entity
@Table(name = "productos")
@Getter
@Setter
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

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

