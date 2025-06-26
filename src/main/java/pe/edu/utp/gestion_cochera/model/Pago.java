package pe.edu.utp.gestion_cochera.model;

import jakarta.persistence.*;
import lombok.Data;
import pe.edu.utp.gestion_cochera.enums.EstadoPago;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    private BigDecimal monto;
    private String metodoPago;
    private LocalDateTime fechaPago;

    @Enumerated(EnumType.STRING)
    private EstadoPago estado;
}