package pe.edu.utp.gestion_cochera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.gestion_cochera.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
