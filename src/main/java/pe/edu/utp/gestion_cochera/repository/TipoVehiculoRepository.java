package pe.edu.utp.gestion_cochera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.gestion_cochera.model.TipoVehiculo;

public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculo, Long> {
}
