package com.inventario.inventario.Categoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "http://localhost:8080")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> getCategorias(){
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Categoria getCategoriaById(@PathVariable Long id){
        return categoriaRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        Categoria nuevaCategoria = categoriaRepository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoria);
    }

    @PutMapping("/{id}")
    public Categoria updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
        Categoria categoriaToUpdate = categoriaRepository.findById(id).get();
        categoriaToUpdate.setNombre(categoria.getNombre());
        categoriaToUpdate.setDescripcion(categoria.getDescripcion());
        return categoriaRepository.save(categoriaToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id){
        try {
            categoriaRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar la categoria");
        }
    }
}
