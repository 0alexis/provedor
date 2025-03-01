package despacho.proveedor.provedor.Dto.despacho;

import java.time.LocalDateTime;

public record RecepcionPedidoDTO(
        Long id,
        String proveedor,
        String producto,
        int cantidad,
        LocalDateTime fechaRecepcion
){}