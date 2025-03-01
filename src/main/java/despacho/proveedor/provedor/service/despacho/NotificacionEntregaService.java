package despacho.proveedor.provedor.service.despacho;


import despacho.proveedor.provedor.model.despacho.NotificacionEntrega;
import despacho.proveedor.provedor.repository.despacho.NotificacionEntregaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificacionEntregaService {

    private final NotificacionEntregaRepository repository;

    public NotificacionEntregaService(NotificacionEntregaRepository repository) {
        this.repository = repository;
    }

    public List<NotificacionEntrega> obtenerTodas() {
        return repository.findAll();
    }

    public Optional<NotificacionEntrega> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public NotificacionEntrega enviarNotificacion(NotificacionEntrega notificacion) {
        notificacion.setFechaNotificacion(LocalDateTime.now());
        return repository.save(notificacion);
    }

    public NotificacionEntrega marcarComoEntregado(Long id) {
        return repository.findById(id).map(notificacion -> {
            notificacion.setEntregado(true);
            return repository.save(notificacion);
        }).orElseThrow(() -> new RuntimeException("Notificación no encontrada"));
    }
}