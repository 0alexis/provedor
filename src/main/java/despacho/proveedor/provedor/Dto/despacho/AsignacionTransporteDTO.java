package despacho.proveedor.provedor.Dto.despacho;


import java.time.LocalDateTime;

public record AsignacionTransporteDTO(
        Long id,
        Long pedidoId,  // ID del pedido asociado
        ConductorDTO conductor,  // Objeto con datos del conductor
        VehiculoDTO vehiculo,   // Objeto con datos del vehículo
        LocalDateTime fechaAsignacion
) {
    // DTO para Conductor con datos adicionales
    public record ConductorDTO(
            Long id,
            String cedula,
            String nombre,
            String apellido
    ) {}

    // DTO para Vehículo con datos adicionales
    public record VehiculoDTO(
            Long id,
            String placa,
            String color
    ) {}
}