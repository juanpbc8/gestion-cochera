package pe.edu.utp.gestion_cochera.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String marca;
    private String modelo;
    private String color;

    @ManyToOne
    private TipoVehiculo tipo;

    @ManyToOne
    private Cliente propietario;

    @OneToMany(mappedBy = "vehiculo")
    private List<Reserva> reservas;
}