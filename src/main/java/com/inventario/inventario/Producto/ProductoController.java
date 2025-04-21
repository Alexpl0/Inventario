package com.inventario.inventario.Producto;

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
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getProductos(){
        return productoRepository.findAll();
    } 

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    @PostMapping // Crea un nuevo producto
    public Producto createProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);

    }

    @PutMapping("/{id}") // Actualiza un producto existente o crea uno nuevo si no existe
    public Producto createOrUpdateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        if (productoRepository.existsById(id)) {
            return updateProducto(id, producto);
        } else {
            producto.setId(id); // Asigna el ID al nuevo producto
            return productoRepository.save(producto);
        }
    }

    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto){
        Producto productoToUpdate = productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        productoToUpdate.setNombre(producto.getNombre());
        productoToUpdate.setCategoria(producto.getCategoria());
        productoToUpdate.setUbicacion(producto.getUbicacion());
        productoToUpdate.setMarca(producto.getMarca()); 
        productoToUpdate.setModelo(producto.getModelo());
        productoToUpdate.setEstado(producto.getEstado());
        productoToUpdate.setDescripcion(producto.getDescripcion());
        productoToUpdate.setPrecio(producto.getPrecio());
        productoToUpdate.setFecha(producto.getFecha());
        return productoRepository.save(productoToUpdate);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
        
        try {
            productoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el producto: " + e.getMessage());
        }
    }
}
