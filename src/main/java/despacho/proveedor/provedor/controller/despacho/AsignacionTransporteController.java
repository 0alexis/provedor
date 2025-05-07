package despacho.proveedor.provedor.controller.despacho;


import despacho.proveedor.provedor.model.despacho.AsignacionTransporte;
import despacho.proveedor.provedor.service.despacho.AsignacionTransporteService;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/despacho/asignacion")
public class AsignacionTransporteController {

    private final AsignacionTransporteService service;

    public AsignacionTransporteController(AsignacionTransporteService service) {
        this.service = service;
    }

    @GetMapping
    public List<AsignacionTransporte> obtenerAsignaciones() {
        return service.obtenerTodasLasAsignaciones();
    }

    @PostMapping
    public AsignacionTransporte asignarTransporte(@RequestBody AsignacionTransporte transporte) {
        return service.asignarTransporte(transporte);
 }
}