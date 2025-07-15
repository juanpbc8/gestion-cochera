package pe.edu.utp.gestion_cochera.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * Entidad JPA que representa un vehículo en el sistema.
 * Contiene información detallada de un cliente
 *
 * @author Joel
 * @version 1.0
 */
@Entity
@Data
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String color;

    @ManyToOne
    private TipoVehiculo tipo;

    @ManyToOne
    private Cliente propietario;

    @OneToMany(mappedBy = "vehiculo")
    private List<Reserva> reservas;
}