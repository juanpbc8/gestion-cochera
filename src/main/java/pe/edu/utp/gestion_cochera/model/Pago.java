package pe.edu.utp.gestion_cochera.model;

import jakarta.persistence.*;
import lombok.Data;

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
    private String metodoPago; // Puede ser: Efectivo, Tarjeta, Yape, etc.
    private LocalDateTime fechaPago;
    private String estado; // Puede ser: Pagado, Pendiente, Fallido
}