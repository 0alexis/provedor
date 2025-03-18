package despacho.proveedor.provedor.controller.despacho;


import despacho.proveedor.provedor.model.despacho.CierreDespacho;
import despacho.proveedor.provedor.service.despacho.CierreDespachoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/despacho/cierre")
public class CierreDespachoController {

    private final CierreDespachoService service;

    public CierreDespachoController(CierreDespachoService service) {
        this.service = service;
    }

    @GetMapping
    public List<CierreDespacho> obtenerCierres() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<CierreDespacho> obtenerCierrePorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public CierreDespacho cerrarDespacho(@RequestBody CierreDespacho cierre) {
        return service.cerrarDespacho(cierre);
    }
}