package pe.edu.utp.gestion_cochera.model;

import jakarta.persistence.*;
import lombok.Data;
import pe.edu.utp.gestion_cochera.enums.EstadoReserva;

import java.time.LocalDate;
import java.time.LocalTime;

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

    private LocalDate fechaReserva;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    @OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL)
    private Pago pago;
}