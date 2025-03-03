package com.inventario.inventario.Ubicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
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

    @OneToMany(mappedBy = "ubicacion")
    private List<Producto> productos;
}
