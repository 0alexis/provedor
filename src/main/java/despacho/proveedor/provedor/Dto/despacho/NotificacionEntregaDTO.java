package despacho.proveedor.provedor.Dto.despacho;


import java.time.LocalDateTime;

public record NotificacionEntregaDTO(
        Long id,
        Long seguimientoId,  // Solo enviamos el ID del seguimiento
        String mensaje,
        boolean entregado,
        LocalDateTime fechaNotificacion
){}
