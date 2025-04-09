/* package com.inventario.inventario.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    
    private final ProductoRepository productoRepository;
    
    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }
    
    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }
    
    public List<Producto> getProductosByCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }
    
    @Transactional
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    
    @Transactional
    public Producto updateProducto(Long id, Producto productoDetails) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        
        if (productoOptional.isPresent()) {
            // Update existing product
            Producto producto = productoOptional.get();
            
            producto.setNombre(productoDetails.getNombre());
            producto.setMarca(productoDetails.getMarca());
            producto.setModelo(productoDetails.getModelo());
            producto.setEstado(productoDetails.getEstado());
            producto.setDescripcion(productoDetails.getDescripcion());
            producto.setPrecio(productoDetails.getPrecio());
            producto.setCategoria(productoDetails.getCategoria());
            producto.setUbicacion(productoDetails.getUbicacion());
            
            return productoRepository.save(producto);
        } else {
            // Crear el  nuevo producto si no existe
            if (id != null) {
                productoDetails.setId(id);
            }
            return productoRepository.save(productoDetails);
        }
    }
    
    @Transactional
    public void deleteProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new ProductoNotFoundException("Producto no encontrado con id: " + id);
        }
        productoRepository.deleteById(id);
    }
    
    
    public boolean existsById(Long id) {
        return productoRepository.existsById(id);
    }
}
*/