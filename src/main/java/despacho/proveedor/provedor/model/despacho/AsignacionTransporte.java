package despacho.proveedor.provedor.model.despacho;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "asignacion_transporte")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsignacionTransporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private RecepcionPedido pedido; // Asumimos una entidad Pedido // Relación con la HU1

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    //desglosar las tablas tanto
    @Column(name = "fecha_asignacion")
    private LocalDateTime fechaAsignacion;

    public Object getEstado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEstado'");
    }

    public void setEstado(Object estado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEstado'");
    }
}



