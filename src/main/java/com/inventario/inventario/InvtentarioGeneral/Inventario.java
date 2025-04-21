package com.inventario.inventario.InvtentarioGeneral;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inventario.inventario.Producto.Producto;

@Entity
@Table(name = "inventario")
@Getter
@Setter
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estado_fisico")
    private String estado_fisico;

    @Column(name = "estado_operativo")
    private String estado_operativo;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "fecha")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "producto_id") // Llave foránea que apunta al producto
    private Producto producto;
}


