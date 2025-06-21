package pe.edu.utp.gestion_cochera.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cochera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private Integer capacidadTotal;
    private Integer disponibilidadActual;

    @OneToMany(mappedBy = "cochera")
    private List<Reserva> reservas;
}