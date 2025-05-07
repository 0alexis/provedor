package despacho.proveedor.provedor.model.despacho;

import lombok.NoArgsConstructor;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cedula;              // Identificador único
    private String nombre;              // Nombre del conductor
    private String apellido;            // Apellido del conductor
    private String telefono;            // Número de contacto
    private String email;               // Correo electrónico
    private String direccion;           // Dirección residencial
}