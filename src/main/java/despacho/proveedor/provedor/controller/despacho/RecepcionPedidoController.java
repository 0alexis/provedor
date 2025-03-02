package despacho.proveedor.provedor.controller.despacho;

import despacho.proveedor.provedor.Dto.despacho.RecepcionPedidoDTO;
import despacho.proveedor.provedor.model.despacho.RecepcionPedido;
import despacho.proveedor.provedor.service.despacho.RecepcionPedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/despacho/recepcion")
@Tag(name = "Recepción de Pedidos", description = "API para gestionar la recepción de pedidos de proveedores")

public class RecepcionPedidoController {

    private final RecepcionPedidoService service;

    public RecepcionPedidoController(RecepcionPedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<RecepcionPedido> obtenerPedidos() {
        return service.obtenerTodos();
    }

    @PostMapping
    public RecepcionPedidoDTO guardarPedido(@RequestBody RecepcionPedidoDTO pedidoDTO) {
        RecepcionPedido pedido = new RecepcionPedido();
        pedido.setProveedor(pedidoDTO.proveedor());
        pedido.setProducto(pedidoDTO.producto());
        pedido.setCantidad(pedidoDTO.cantidad());
        pedido.setFechaRecepcion(pedidoDTO.fechaRecepcion());

        RecepcionPedido pedidoGuardado = service.guardar(pedido);
        return new RecepcionPedidoDTO(
                pedidoGuardado.getId(),
                pedidoGuardado.getProveedor(),
                pedidoGuardado.getProducto(),
                pedidoGuardado.getCantidad(),
                pedidoGuardado.getFechaRecepcion()
                );
    }
}
