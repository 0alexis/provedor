package despacho.proveedor.provedor.controller.despacho;

import despacho.proveedor.provedor.model.despacho.AsignacionTransporte;
import despacho.proveedor.provedor.service.despacho.AsignacionTransporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Controlador REST para la gestión de asignaciones de transporte.
 * Proporciona endpoints para obtener todas las asignaciones y crear nuevas asignaciones.
 */
@RestController
@RequestMapping("/api/despacho/asignacion")
public class AsignacionTransporteController {

    private final AsignacionTransporteService service;

    /**
     * Constructor que inyecta el servicio de asignaciones de transporte.
     * @param service Servicio para gestionar las asignaciones de transporte.
     */
    @Autowired
    public AsignacionTransporteController(AsignacionTransporteService service) {
        this.service = service;
    }

    /**
     * Obtiene todas las asignaciones de transporte.
     * @return Lista de asignaciones de transporte en una respuesta HTTP.
     */
    @GetMapping
    public ResponseEntity<List<AsignacionTransporte>> obtenerAsignaciones() {
        List<AsignacionTransporte> asignaciones = service.obtenerTodos();
        return ResponseEntity.ok(asignaciones);
    }

    /**
     * Crea una nueva asignación de transporte.
     * @param transporte Objeto de asignación de transporte recibido en el cuerpo de la solicitud.
     * @return La asignación de transporte creada en una respuesta HTTP.
     */
    @PostMapping
    public ResponseEntity<AsignacionTransporte> asignarTransporte(@RequestBody AsignacionTransporte transporte) {
        AsignacionTransporte nuevaAsignacion = service.asignarTransporte(transporte);
        return ResponseEntity.ok(nuevaAsignacion);
    }
}
