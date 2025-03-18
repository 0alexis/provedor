package despacho.proveedor.provedor.repository.despacho;
import despacho.proveedor.provedor.model.despacho.RecepcionPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RecepcionPedidoRepository extends JpaRepository<RecepcionPedido, Long>{
        }

