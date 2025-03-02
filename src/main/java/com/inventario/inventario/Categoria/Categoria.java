package com.inventario.inventario.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.inventario.inventario.Producto.Producto;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@AllArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "ubicaion_id")
    private String ubicaion_id;
}
