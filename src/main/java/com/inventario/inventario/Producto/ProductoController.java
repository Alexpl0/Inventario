package com.inventario.inventario.Producto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.inventario.Categoria.Categoria;
import com.inventario.inventario.Categoria.CategoriaRepository;
import com.inventario.inventario.Ubicacion.Ubicacion;
import com.inventario.inventario.Ubicacion.UbicacionRepository;

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

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @GetMapping
    public List<Producto> getProductos(){
        return productoRepository.findAll();
    } 

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoRepository.findById(id).get();
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto){
        Producto productoToUpdate = productoRepository.findById(id).get();
        productoToUpdate.setNombre(producto.getNombre());
        productoToUpdate.setCategoria(producto.getCategoria());
        productoToUpdate.setUbicacion(producto.getUbicacion());
        productoToUpdate.setMarca(producto.getMarca()); 
        productoToUpdate.setModelo(producto.getModelo());
        productoToUpdate.setEstado(producto.getEstado());
        productoToUpdate.setDescripcion(producto.getDescripcion());
        productoToUpdate.setPrecio(producto.getPrecio());
        
        return productoRepository.save(productoToUpdate);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id){
        try {
            productoRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar el producto");
        }
    }
}

/*
 * // Obtener la categoría actual del producto
        Categoria categoria = categoriaRepository.findById(productoToUpdate.getCategoriaId()).orElse(null);
        if (categoria != null) {
            productoToUpdate.setCategoriaId(categoria.getId());
        }

        // Obtener la ubicación actual del producto
        Ubicacion ubicacion = ubicacionRepository.findById(productoToUpdate.getUbicacionId()).orElse(null);
        if (ubicacion != null) {
            productoToUpdate.setUbicacionId(ubicacion.getId());
        }
 */