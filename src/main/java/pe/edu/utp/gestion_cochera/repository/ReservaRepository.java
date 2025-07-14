package pe.edu.utp.gestion_cochera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.gestion_cochera.enums.EstadoReserva;
import pe.edu.utp.gestion_cochera.model.Cliente;
import pe.edu.utp.gestion_cochera.model.Reserva;

import java.util.List;

/**
 * Repositorio JPA para la entidad {@link Reserva}.
 * Proporciona métodos personalizados para consultas según estado o cliente.
 *
 * @author Juan
 * @version 1.0
 */
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    /**
     * Obtiene una lista de reservas que coinciden con el estado proporcionado.
     *
     * @param estadoReserva Estado de la reserva (PENDIENTE, CONFIRMADA o CANCELADA)
     * @return Lista de reservas con el estado especificado
     */
    List<Reserva> findByEstado(EstadoReserva estadoReserva);

    /**
     * Cuenta cuántas reservas existen con el estado dado.
     *
     * @param estadoReserva Estado de la reserva
     * @return Número de reservas con ese estado
     */
    long countByEstado(EstadoReserva estadoReserva);

    /**
     * Obtiene todas las reservas realizadas por un cliente específico.
     *
     * @param cliente Cliente del cual se desean obtener las reservas
     * @return Lista de reservas realizadas por el cliente
     */
    List<Reserva> findByCliente(Cliente cliente);
}
