package despacho.proveedor.provedor.repository.despacho;


import despacho.proveedor.provedor.model.despacho.AsignacionTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignacionTransporteRepository extends JpaRepository<AsignacionTransporte,Long>{
        }