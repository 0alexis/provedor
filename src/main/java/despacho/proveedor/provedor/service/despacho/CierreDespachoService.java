package despacho.proveedor.provedor.service.despacho;


import despacho.proveedor.provedor.model.despacho.CierreDespacho;
import despacho.proveedor.provedor.repository.despacho.CierreDespachoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CierreDespachoService {

    private final CierreDespachoRepository repository;

    public CierreDespachoService(CierreDespachoRepository repository) {
        this.repository = repository;
    }

    public List<CierreDespacho> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<CierreDespacho> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public CierreDespacho cerrarDespacho(CierreDespacho cierre) {
        cierre.setFechaCierre(LocalDateTime.now());
        cierre.setCerrado(true);
        return repository.save(cierre);
 }
}
