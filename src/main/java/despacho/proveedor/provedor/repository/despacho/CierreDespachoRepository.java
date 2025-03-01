package despacho.proveedor.provedor.repository.despacho;


import despacho.proveedor.provedor.model.despacho.CierreDespacho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CierreDespachoRepository extends JpaRepository<CierreDespacho,Long>{
        }