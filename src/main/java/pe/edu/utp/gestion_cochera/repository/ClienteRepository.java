package pe.edu.utp.gestion_cochera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.gestion_cochera.model.Cliente;

/**
 * Repositorio JPA para la entidad {@link Cliente}.
 * Permite consultar y gestionar clientes desde la base de datos.
 *
 * @author Joel
 * @version 1.0
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
