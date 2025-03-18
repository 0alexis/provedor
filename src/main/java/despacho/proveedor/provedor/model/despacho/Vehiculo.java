package despacho.proveedor.provedor.model.despacho;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;               // Identificador único
    private String color;               // Color del vehículo
    private int capacidad;              // Capacidad en kg o unidades
    private String modelo;              // Modelo del vehículo
    private String marca;               // Marca del vehículo
}