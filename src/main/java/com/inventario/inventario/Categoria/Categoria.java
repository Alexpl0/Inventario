package com.inventario.inventario.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.inventario.inventario.Producto.Producto;

@Entity
@Table(name = "categorias")
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @JsonManagedReference
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Producto> productos;

    
    //@OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinColumn(name = "producto_id", referencedColumnName = "id") // Añadir esta línea
    //private Set<Producto> productos;
}
