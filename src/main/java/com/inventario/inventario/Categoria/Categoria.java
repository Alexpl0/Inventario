package com.inventario.inventario.Categoria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
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

    @OneToMany(mappedBy = "categoria")
    // Esta anotación indica que hay una relación de uno a muchos entre `Categoria` y `Producto`.
    // El atributo `mappedBy` especifica que el lado inverso de la relación está en el campo `categoria` de la clase `Producto`.
    private List<Producto> productos;
    // Esta línea define una lista de objetos `Producto` que están asociados con una instancia de `Categoria`.
    // Es decir, una categoría puede tener múltiples productos asociados.

    @Column(name = "descripcion")
    private String descripcion;
}
