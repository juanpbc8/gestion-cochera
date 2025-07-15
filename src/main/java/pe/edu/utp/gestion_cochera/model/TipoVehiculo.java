package pe.edu.utp.gestion_cochera.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Entidad JPA que representa un tipo de vehículo.
 * Define el nombre del tipo (auto, moto, etc.) y la tarifa por hora correspondiente.
 * Se relaciona con la entidad Vehiculo.
 *
 * @author Stephano
 * @version 1.0
 */
@Entity
@Data
public class TipoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private BigDecimal tarifaHora;

    @OneToMany(mappedBy = "tipo")
    private List<Vehiculo> vehiculos;
}
