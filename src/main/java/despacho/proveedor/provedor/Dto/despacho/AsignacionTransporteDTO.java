package despacho.proveedor.provedor.Dto.despacho;


import java.time.LocalDateTime;

public record AsignacionTransporteDTO(
        Long id,
        Long pedidoId,  // Solo enviamos el ID del pedido
        String vehiculo,
        String conductor,
        LocalDateTime fechaAsignacion
){}