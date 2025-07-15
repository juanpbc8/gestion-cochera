package pe.edu.utp.gestion_cochera.model;

import jakarta.persistence.*;
import lombok.Data;
import pe.edu.utp.gestion_cochera.enums.EstadoReserva;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Entidad JPA que representa una reserva en el sistema.
 * Define el período de tiempo reservado mediante una fecha y un rango horario (inicio y fin).
 * Cada reserva está relacionada con un {@link Cliente}, un {@link Vehiculo} y una {@link Cochera}.
 *
 * @author Juan
 * @version 1.0
 */
@Entity
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Vehiculo vehiculo;

    @ManyToOne
    private Cochera cochera;

    @Column(nullable = false)
    private LocalDate fechaReserva;

    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoReserva estado;

    @OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL)
    private Pago pago;
}