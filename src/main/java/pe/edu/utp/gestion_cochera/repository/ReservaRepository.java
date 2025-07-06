package pe.edu.utp.gestion_cochera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.gestion_cochera.enums.EstadoPago;
import pe.edu.utp.gestion_cochera.enums.EstadoReserva;
import pe.edu.utp.gestion_cochera.model.Reserva;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByEstado(EstadoReserva estadoReserva);

    long countByEstado(EstadoReserva estadoReserva);
}
