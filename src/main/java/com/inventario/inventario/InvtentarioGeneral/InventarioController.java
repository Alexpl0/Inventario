package com.inventario.inventario.InvtentarioGeneral;
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
@RequestMapping("/inventario")
public class InventarioController {
    @Autowired
    private InventarioRepository inventarioRepository;
    
    @GetMapping
    public List<Inventario> getInventarios(){
        return inventarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Inventario getInventarioById(@PathVariable Long id){
        return inventarioRepository.findById(id).get();
    }

    @PostMapping
    public Inventario createInventario(@RequestBody Inventario inventario){
        return inventarioRepository.save(inventario);
    }

    @PutMapping("/{id}")
    public Inventario updateInventario(@PathVariable Long id, @RequestBody Inventario inventario) {
        Inventario inventarioToUpdate = inventarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Inventario no encontrado con ID: " + id));

        inventarioToUpdate.setEstado_fisico(inventario.getEstado_fisico());
        inventarioToUpdate.setEstado_operativo(inventario.getEstado_operativo());
        inventarioToUpdate.setObservaciones(inventario.getObservaciones());
        inventarioToUpdate.setFecha(inventario.getFecha());

        if (inventario.getProducto() != null && inventario.getProducto().getId() != null) {
            inventarioToUpdate.setProducto(inventario.getProducto());
        }

        return inventarioRepository.save(inventarioToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteInventario(@PathVariable Long id) {
        if (!inventarioRepository.existsById(id)) {
            throw new RuntimeException("Inventario no encontrado con ID: " + id);
        }
        inventarioRepository.deleteById(id);
    }
}
