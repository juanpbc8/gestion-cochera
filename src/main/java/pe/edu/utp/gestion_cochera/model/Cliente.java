package pe.edu.utp.gestion_cochera.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;
    private String dni;
    private String telefono;
    private String email;

    @OneToMany(mappedBy = "propietario")
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;
}