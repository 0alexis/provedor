package despacho.proveedor.provedor.model.despacho;



import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cierre_despacho")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CierreDespacho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "notificacion_id", nullable = false)
    private NotificacionEntrega notificacion;  // Relación con HU4

    private String observaciones;
    private boolean cerrado;

    @Column(name = "fecha_cierre")
    private LocalDateTime fechaCierre;
}