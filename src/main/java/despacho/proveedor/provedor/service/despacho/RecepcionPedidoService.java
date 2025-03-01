package despacho.proveedor.provedor.service.despacho;


import despacho.proveedor.provedor.model.despacho.RecepcionPedido;
import despacho.proveedor.provedor.repository.despacho.RecepcionPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecepcionPedidoService {

    private final RecepcionPedidoRepository repository;

    public RecepcionPedidoService(RecepcionPedidoRepository repository) {
        this.repository = repository;
    }

    public List<RecepcionPedido> obtenerTodos() {
        return repository.findAll();
    }

    public RecepcionPedido guardar(RecepcionPedido pedido) {
        return repository.save(pedido);
}
}
