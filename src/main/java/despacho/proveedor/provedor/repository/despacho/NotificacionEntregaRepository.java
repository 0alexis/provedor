package despacho.proveedor.provedor.repository.despacho;

import despacho.proveedor.provedor.model.despacho.NotificacionEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionEntregaRepository extends JpaRepository<NotificacionEntrega,Long>{
        }