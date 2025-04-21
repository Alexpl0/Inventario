package com.inventario.inventario.Salas;


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
@RequestMapping("/salas")
public class SalasController {

    @Autowired
    private SalasRepository salasRepository;

    @GetMapping
    public List<Salas> getAllSalas() {
        return salasRepository.findAll();
    }

    @GetMapping("/{id}")
    public Salas getSalaById(@PathVariable Long id) {
        return salasRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Salas createSala(@RequestBody Salas sala) {
        return salasRepository.save(sala);
    }

    @PutMapping("/{id}")
    public Salas createOrUpdateSala(@PathVariable Long id, @RequestBody Salas sala) {
        if (salasRepository.existsById(id)) {
            return updateSala(id, sala);
        } else {
            sala.setId(id);
            return salasRepository.save(sala);
        }
    }
    
    public Salas updateSala(@PathVariable Long id, @RequestBody Salas sala) {
        Salas salasToUpdate = salasRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Sala no encontrado con ID: " + id));
        if (salasToUpdate != null) {
            salasToUpdate.setNombre(sala.getNombre());
            salasToUpdate.setCapacidad(sala.getCapacidad());
            return salasRepository.save(salasToUpdate);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSala(@PathVariable Long id) {
        if(!salasRepository.existsById(id)) {
            throw new RuntimeException("Sala no encontrado con ID: " + id);
        }
        try {
            salasRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la sala con ID: " + id, e);
        }
    }

}
