package pe.edu.utp.gestion_cochera.model;

import jakarta.persistence.*;
import lombok.Data;
import pe.edu.utp.gestion_cochera.enums.EstadoPago;
import pe.edu.utp.gestion_cochera.enums.MetodoPago;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entidad JPA que representa un pago en el sistema.
 * Contiene información detallada sobre el monto, método de pago, fecha de transacción,
 * estado actual del pago y un código único generado para su identificación.
 * Cada pago está relacionado con una {@link Reserva}.
 *
 * @author Juan
 * @version 1.0
 */
@Entity
@Data
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    @Column(nullable = false)
    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MetodoPago metodo;

    @Column(nullable = false)
    private LocalDate fechaPago;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPago estado;

    @Column(nullable = false)
    private String codigo;
}