package despacho.proveedor.provedor.model.despacho;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "seguimiento_despacho")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeguimientoDespacho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "asignacion_id", nullable = false)
    private AsignacionTransporte asignacion;  // Relación con HU2

    private String ubicacionActual;
    private String estado; // "En tránsito", "Entregado", "Retrasado"

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;
}
