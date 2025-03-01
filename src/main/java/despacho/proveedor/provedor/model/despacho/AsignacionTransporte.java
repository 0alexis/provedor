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

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private RecepcionPedido pedido;  // Relación con la HU1

    private String vehiculo;
    private String conductor;

    @Column(name = "fecha_asignacion")
    private LocalDateTime fechaAsignacion;
}