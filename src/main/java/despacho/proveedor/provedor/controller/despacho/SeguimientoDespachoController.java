package despacho.proveedor.provedor.controller.despacho;



import despacho.proveedor.provedor.model.despacho.SeguimientoDespacho;
import despacho.proveedor.provedor.service.despacho.SeguimientoDespachoService;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/despacho/seguimiento")
public class SeguimientoDespachoController {

    private final SeguimientoDespachoService service;

    public SeguimientoDespachoController(SeguimientoDespachoService service) {
        this.service = service;
    }

    @GetMapping
    public List<SeguimientoDespacho> obtenerSeguimientos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<SeguimientoDespacho> obtenerSeguimientoPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public SeguimientoDespacho registrarSeguimiento(@RequestBody SeguimientoDespacho seguimiento) {
        return service.registrarSeguimiento(seguimiento);
    }

    @PutMapping("/{id}")
    public SeguimientoDespacho actualizarSeguimiento(@PathVariable Long id, @RequestBody SeguimientoDespacho seguimiento) {
        return service.actualizarSeguimiento(id, seguimiento);
    }
}