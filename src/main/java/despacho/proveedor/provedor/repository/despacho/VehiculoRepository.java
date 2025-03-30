package despacho.proveedor.provedor.repository.despacho;

import despacho.proveedor.provedor.model.despacho.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    Optional<Vehiculo> findByPlaca(String placa);
    Optional<Vehiculo> findByColor(String color); // Opcional
}





