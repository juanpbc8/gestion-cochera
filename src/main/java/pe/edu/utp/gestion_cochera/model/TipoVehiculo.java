package pe.edu.utp.gestion_cochera.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class TipoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private BigDecimal tarifaHora;

    @OneToMany(mappedBy = "tipo")
    private List<Vehiculo> vehiculos;
}
