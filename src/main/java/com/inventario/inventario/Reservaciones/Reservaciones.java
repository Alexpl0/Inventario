package com.inventario.inventario.Reservaciones;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

import com.inventario.inventario.Salas.Salas;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "rerservaciones")
@Getter
@Setter
public class Reservaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="fecha_entrada")
    private LocalDateTime fechaEntrada;

    @Column(name="fecha_salida")
    private LocalDateTime fechaSalida;

    @Column(name="motivo")
    private String motivo;

    @Column(name="cantidad_personas")
    private int cantidadPersonas;

    @Column(name="fecha_reservacion")
    private LocalDateTime fechaReservacion;

    @Column(name="nombre_reservador")
    private String nombreReservador;

    @ManyToOne
    @JoinColumn(name = "salas_id")
    private Salas sala;
    
}
