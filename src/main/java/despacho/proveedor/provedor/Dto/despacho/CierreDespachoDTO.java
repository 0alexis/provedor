package despacho.proveedor.provedor.Dto.despacho;

import java.time.LocalDateTime;

public record CierreDespachoDTO(
        Long id,
        Long notificacionId,  // Solo enviamos el ID de la notificación
        String observaciones,
        boolean cerrado,
        LocalDateTime fechaCierre
){}
