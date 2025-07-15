package pe.edu.utp.gestion_cochera.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * Entidad JPA que representa una cochera en el sistema.
 * Cada cochera puede ser usada para reservas y tiene una capacidad total y actual.
 * Está relacionada con la entidad Reserva.
 *
 * @author Stephano
 * @version 1.0
 */
@Entity
@Data
public class Cochera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private Integer capacidadTotal;

    @Column(nullable = false)
    private Integer disponibilidadActual;

    @OneToMany(mappedBy = "cochera")
    private List<Reserva> reservas;
}