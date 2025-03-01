package despacho.proveedor.provedor.service;

import despacho.proveedor.provedor.model.Producto;
import despacho.proveedor.provedor.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    @Autowired
    private ProductoRepository productoRepository;

    public boolean verificarStock(Long productoId, int cantidadSolicitada) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return producto.getStockDisponible() >= cantidadSolicitada;
    }

    @Transactional
    public void reservarStock(Long productoId, int cantidadSolicitada) {
        if (!verificarStock(productoId, cantidadSolicitada)) {
            throw new RuntimeException("Stock insuficiente para el producto: " + productoId);
        }
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setStockDisponible(producto.getStockDisponible() - cantidadSolicitada);
        productoRepository.save(producto);
    }
}