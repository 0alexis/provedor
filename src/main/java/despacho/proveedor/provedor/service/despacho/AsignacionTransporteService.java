package despacho.proveedor.provedor.service.despacho;


import despacho.proveedor.provedor.model.despacho.AsignacionTransporte;
import despacho.proveedor.provedor.repository.despacho.AsignacionTransporteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionTransporteService {

    private final AsignacionTransporteRepository repository;

    public AsignacionTransporteService(AsignacionTransporteRepository repository) {
        this.repository = repository;
    }

    public List<AsignacionTransporte> obtenerTodos() {
        return repository.findAll();
    }

    public AsignacionTransporte asignarTransporte(AsignacionTransporte transporte) {
        return repository.save(transporte);
 }
}
