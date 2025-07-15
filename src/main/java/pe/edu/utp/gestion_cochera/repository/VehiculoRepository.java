package pe.edu.utp.gestion_cochera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.gestion_cochera.model.Vehiculo;

/**
 * Repositorio JPA para la entidad {@link Vehiculo}.
 * Permite consultar y gestionar vehículos desde la base de datos.
 *
 * @author Joel
 * @version 1.0
 */
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}
