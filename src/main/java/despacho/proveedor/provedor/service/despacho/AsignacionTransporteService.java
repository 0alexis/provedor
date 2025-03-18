package despacho.proveedor.provedor.service.despacho;

import despacho.proveedor.provedor.model.despacho.AsignacionTransporte;
import despacho.proveedor.provedor.model.despacho.Conductor;
import despacho.proveedor.provedor.model.despacho.Vehiculo;
import despacho.proveedor.provedor.repository.despacho.AsignacionTransporteRepository;
import despacho.proveedor.provedor.repository.despacho.ConductorRepository;
import despacho.proveedor.provedor.repository.despacho.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.time.LocalDateTime;
import java.util.List;

// Paquetes importados:
// - Modelos (AsignacionTransporte, Conductor, Vehiculo) para representar datos de negocio.
// - Repositorios para interactuar con la base de datos (usando Spring Data JPA).
// - Anotaciones de Spring (@Autowired, @Service) para inyección de dependencias y definición de servicio.
// - Optional para manejar valores nulos de forma segura.
// - LocalDateTime para manejar fechas y horas.

@Service
public class AsignacionTransporteService {

    // Anotación @Service: Indica que esta clase es un servicio de Spring, gestionado por el contenedor de IoC.
    // Esto permite inyección de dependencias y uso en otros componentes (como controladores).

    @Autowired
    private AsignacionTransporteRepository asignacionRepository;
    // Inyección de dependencias del repositorio para AsignacionTransporte.
    // @Autowired: Spring inyecta automáticamente una instancia del repositorio en esta variable.
    // Este repositorio se usa para guardar y recuperar asignaciones de transporte en la base de datos.

    @Autowired
    private ConductorRepository conductorRepository;    
    // Inyección del repositorio para Conductor.
    // Permite buscar conductores por criterios como cédula.

    @Autowired
    private VehiculoRepository vehiculoRepository;
    // Inyección del repositorio para Vehiculo.
    // Permite buscar vehículos por criterios como placa.

    public AsignacionTransporte asignarTransporte(AsignacionTransporte dto) {
        // Validar y obtener conductor
        Optional<Conductor> conductorOpt = conductorRepository.findByCedula(dto.getConductor().getCedula());
        Conductor conductor = conductorOpt.orElseThrow(() -> 
            new RuntimeException("Conductor no encontrado con cédula: " + dto.getConductor().getCedula()));

        // Validar y obtener vehículo
        Optional<Vehiculo> vehiculoOpt = vehiculoRepository.findByPlaca(dto.getVehiculo().getPlaca());
        Vehiculo vehiculo = vehiculoOpt.orElseThrow(() -> 
            new RuntimeException("Vehículo no encontrado con placa: " + dto.getVehiculo().getPlaca()));

        // Crear y configurar la asignación
        AsignacionTransporte asignacion = new AsignacionTransporte();
        asignacion.setPedido(dto.getPedido());
        asignacion.setConductor(conductor);
        asignacion.setVehiculo(vehiculo);
        asignacion.setFechaAsignacion(dto.getFechaAsignacion() != null ? 
            dto.getFechaAsignacion() : LocalDateTime.now());
        asignacion.setEstado("ASIGNADO");

        // Guardar y retornar la asignación
        return asignacionRepository.save(asignacion);
    }

    public List<AsignacionTransporte> obtenerTodasLasAsignaciones() {
        return asignacionRepository.findAll();
    }

    public Optional<AsignacionTransporte> obtenerAsignacionPorId(Long id) {
        return asignacionRepository.findById(id);
    }

    public void eliminarAsignacion(Long id) {
        asignacionRepository.deleteById(id);
    }

    public AsignacionTransporte actualizarAsignacion(Long id, AsignacionTransporte dto) {
        return asignacionRepository.findById(id)
            .map(asignacion -> {
                // Validar y obtener conductor si se proporciona
                if (dto.getConductor() != null && dto.getConductor().getCedula() != null) {
                    Conductor conductor = conductorRepository.findByCedula(dto.getConductor().getCedula())
                        .orElseThrow(() -> new RuntimeException("Conductor no encontrado con cédula: " + 
                            dto.getConductor().getCedula()));
                    asignacion.setConductor(conductor);
                }

                // Validar y obtener vehículo si se proporciona
                if (dto.getVehiculo() != null && dto.getVehiculo().getPlaca() != null) {
                    Vehiculo vehiculo = vehiculoRepository.findByPlaca(dto.getVehiculo().getPlaca())
                        .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con placa: " + 
                            dto.getVehiculo().getPlaca()));
                    asignacion.setVehiculo(vehiculo);
                }

                if (dto.getFechaAsignacion() != null) {
                    asignacion.setFechaAsignacion(dto.getFechaAsignacion());
                }
                if (dto.getEstado() != null) {
                    asignacion.setEstado(dto.getEstado());
                }
                return asignacionRepository.save(asignacion);
            })
            .orElseThrow(() -> new RuntimeException("Asignación no encontrada con ID: " + id));
    }
}