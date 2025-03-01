package despacho.proveedor.provedor.model.despacho;


import jakarta.persistence.*;
        import lombok.*;

        import java.time.LocalDateTime;

@Entity
@Table(name = "notificacion_entrega")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "seguimiento_id", nullable = false)
    private SeguimientoDespacho seguimiento;  // Relación con HU3

    private String mensaje;
    private boolean entregado;

    @Column(name = "fecha_notificacion")
    private LocalDateTime fechaNotificacion;
}