package despacho.proveedor.provedor.service.despacho;


import despacho.proveedor.provedor.model.despacho.SeguimientoDespacho;
import despacho.proveedor.provedor.repository.despacho.SeguimientoDespachoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeguimientoDespachoService {

    private final SeguimientoDespachoRepository repository;

    public SeguimientoDespachoService(SeguimientoDespachoRepository repository) {
        this.repository = repository;
    }

    public List<SeguimientoDespacho> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<SeguimientoDespacho> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public SeguimientoDespacho registrarSeguimiento(SeguimientoDespacho seguimiento) {
        return repository.save(seguimiento);
    }
// rama de daniel
    public SeguimientoDespacho actualizarSeguimiento(Long id, SeguimientoDespacho seguimientoActualizado) {
        return repository.findById(id).map(seguimiento -> {
            seguimiento.setUbicacionActual(seguimientoActualizado.getUbicacionActual());
            seguimiento.setEstado(seguimientoActualizado.getEstado());
            seguimiento.setFechaActualizacion(seguimientoActualizado.getFechaActualizacion());
            return repository.save(seguimiento);
        }).orElseThrow(() -> new RuntimeException("Seguimiento no encontrado"));
    }
}