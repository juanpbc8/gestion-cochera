package pe.edu.utp.gestion_cochera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.gestion_cochera.model.TipoVehiculo;

/**
 * Repositorio JPA para la entidad {@link TipoVehiculo}.
 * Permite consultar y gestionar tipos de vehículo desde la base de datos.
 *
 * @author Stephano
 * @version 1.0
 */
public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculo, Long> {
}
