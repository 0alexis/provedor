package despacho.proveedor.provedor.model.despacho;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "recepcion_pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

    public class RecepcionPedido {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String proveedor;
        private String producto;
        private int cantidad;

        @Column(name = "fecha_recepcion")
        private LocalDateTime fechaRecepcion;
    }


