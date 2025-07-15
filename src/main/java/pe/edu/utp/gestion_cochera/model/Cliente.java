package pe.edu.utp.gestion_cochera.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * Entidad JPA que representa un cliente en el sistema.
 * Contiene información detallada de un cliente
 *
 * @author Joel
 * @version 1.0
 */
@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreCompleto;

    @Column(nullable = false)
    private String dni;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "propietario")
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;
}