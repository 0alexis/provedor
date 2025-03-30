package despacho.proveedor.provedor.repository.despacho;

import despacho.proveedor.provedor.model.despacho.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    Optional<Conductor> findByCedula(String cedula);
    Optional<Conductor> findByNombreAndApellido(String nombre, String apellido); // Opcional
}



