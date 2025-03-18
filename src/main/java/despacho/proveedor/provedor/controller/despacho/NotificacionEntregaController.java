package despacho.proveedor.provedor.controller.despacho;

import despacho.proveedor.provedor.model.despacho.NotificacionEntrega;
import despacho.proveedor.provedor.service.despacho.NotificacionEntregaService;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/despacho/notificacion")
public class NotificacionEntregaController {

    private final NotificacionEntregaService service;

    public NotificacionEntregaController(NotificacionEntregaService service) {
        this.service = service;
    }

    @GetMapping
    public List<NotificacionEntrega> obtenerNotificaciones() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<NotificacionEntrega> obtenerNotificacionPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public NotificacionEntrega enviarNotificacion(@RequestBody NotificacionEntrega notificacion) {
        return service.enviarNotificacion(notificacion);
    }

    @PutMapping("/{id}/confirmar")
    public NotificacionEntrega marcarComoEntregado(@PathVariable Long id) {
        return service.marcarComoEntregado(id);
    }
}