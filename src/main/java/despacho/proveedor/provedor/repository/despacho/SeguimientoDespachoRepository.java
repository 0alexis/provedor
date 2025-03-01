package despacho.proveedor.provedor.repository.despacho;


import despacho.proveedor.provedor.model.despacho.SeguimientoDespacho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguimientoDespachoRepository extends JpaRepository<SeguimientoDespacho,Long>{
        }