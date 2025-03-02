package com.inventario.inventario.Ubicacion;
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
@RequestMapping("/ubicaciones")
public class UbicacionController {
    @Autowired
    private UbicacionRepository ubicacionRepository;

    @GetMapping
    public List<Ubicacion> getUbicaciones(){
        return ubicacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ubicacion getUbicacionById(@PathVariable Long id){
        return ubicacionRepository.findById(id).get();
    }

    @PostMapping
    public Ubicacion createUbicacion(@RequestBody Ubicacion ubicacion){
        return ubicacionRepository.save(ubicacion);
    }

    @PutMapping("/{id}")
    public Ubicacion updateUbicacion(@PathVariable Long id, @RequestBody Ubicacion ubicacion){
        Ubicacion ubicacionToUpdate = ubicacionRepository.findById(id).get();
        ubicacionToUpdate.setNombre(ubicacion.getNombre());
        return ubicacionRepository.save(ubicacionToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteUbicacion(@PathVariable Long id){
        try {
            ubicacionRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar la ubicación");
        }
    }
}
