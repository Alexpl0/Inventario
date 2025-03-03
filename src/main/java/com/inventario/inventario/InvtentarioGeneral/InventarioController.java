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
    public Inventario updateInventario(@PathVariable Long id, @RequestBody Inventario inventario){
        Inventario inventarioToUpdate = inventarioRepository.findById(id).get();
        inventarioToUpdate.setNombre(inventario.getNombre());
        inventarioToUpdate.setCategoria(inventario.getCategoria());
        inventarioToUpdate.setUbicacion(inventario.getUbicacion());
        inventarioToUpdate.setMarca(inventario.getMarca()); 
        inventarioToUpdate.setModelo(inventario.getModelo());
        inventarioToUpdate.setEstado(inventario.getEstado());
        inventarioToUpdate.setDescripcion(inventario.getDescripcion());
        inventarioToUpdate.setPrecio(inventario.getPrecio());
        
        return inventarioRepository.save(inventarioToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteInventario(@PathVariable Long id){
        try {
            inventarioRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar el inventario");
        }
    }
}
