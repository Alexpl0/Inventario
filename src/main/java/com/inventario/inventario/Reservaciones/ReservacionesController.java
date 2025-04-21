package com.inventario.inventario.Reservaciones;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/reservaciones")
public class ReservacionesController {
    @Autowired
    private ReservacionesRepository reservacionesRepository;

    @GetMapping
    public List<Reservaciones> getAllReservaciones() {
        return reservacionesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reservaciones getReservacionById(@PathVariable Long id) {
        return reservacionesRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Reservaciones createReservacion(@RequestBody Reservaciones reservacion) {
        return reservacionesRepository.save(reservacion);
    }

    @PutMapping("/{id}")
    public Reservaciones createOrUpdateReservacion(@PathVariable Long id, @RequestBody Reservaciones reservacion) {
        if (reservacionesRepository.existsById(id)) {
           return updateReservacion(id, reservacion);
        } else {
            reservacion.setId(id);
            return reservacionesRepository.save(reservacion);

        }
    }

    public Reservaciones updateReservacion(@PathVariable Long id, @RequestBody Reservaciones reservacion) {
        Reservaciones reservacionesToUpdate = reservacionesRepository.findById(id).orElse(null);
        if (reservacionesToUpdate != null) {
            reservacionesToUpdate.setFechaEntrada(reservacion.getFechaEntrada());
            reservacionesToUpdate.setFechaSalida(reservacion.getFechaSalida());
            reservacionesToUpdate.setMotivo(reservacion.getMotivo());
            reservacionesToUpdate.setCantidadPersonas(reservacion.getCantidadPersonas());
            reservacionesToUpdate.setFechaReservacion(reservacion.getFechaReservacion());
            reservacionesToUpdate.setNombreReservador(reservacion.getNombreReservador());
            return reservacionesRepository.save(reservacionesToUpdate);
        } else {
            return null;
        }
            
    }

    @DeleteMapping("/{id}")
    public void deleteReservacion(@PathVariable Long id) {
        if (reservacionesRepository.existsById(id)) {
            reservacionesRepository.deleteById(id);
        } else {
            throw new RuntimeException("Reservacion not found with id: " + id);
        }
        try {
            reservacionesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting reservacion with id: " + id, e);
        }
    }




}
