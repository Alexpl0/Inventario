package com.inventario.inventario.Salas;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inventario.inventario.Reservaciones.Reservaciones;

import java.time.LocalDate;

@Entity
@Table(name = "salas")
@Getter
@Setter

public class Salas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "capacidad")
    private int capacidad;


    @JsonIgnore
    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservaciones> reservaciones;

}
