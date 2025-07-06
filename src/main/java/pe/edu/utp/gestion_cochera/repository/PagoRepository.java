package pe.edu.utp.gestion_cochera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.gestion_cochera.enums.EstadoPago;
import pe.edu.utp.gestion_cochera.enums.MetodoPago;
import pe.edu.utp.gestion_cochera.model.Pago;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByEstado(EstadoPago estado);

    List<Pago> findByMetodo(MetodoPago metodo);

    long countByMetodo(MetodoPago metodo);

    long countByEstado(EstadoPago estado);

    List<Pago> findByEstadoAndMetodo(EstadoPago estado, MetodoPago metodo);
}
