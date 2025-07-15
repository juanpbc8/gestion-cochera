package pe.edu.utp.gestion_cochera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.gestion_cochera.model.Cochera;

/**
 * Repositorio JPA para la entidad {@link Cochera}.
 * Proporciona métodos de acceso a la base de datos para gestionar cocheras.
 *
 * @author Stephano
 * @version 1.0
 */
public interface CocheraRepository extends JpaRepository<Cochera, Long> {
}
