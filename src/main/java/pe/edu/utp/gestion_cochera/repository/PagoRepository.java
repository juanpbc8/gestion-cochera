package pe.edu.utp.gestion_cochera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.gestion_cochera.model.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
}
