package pe.edu.utp.gestion_cochera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.gestion_cochera.enums.EstadoPago;
import pe.edu.utp.gestion_cochera.enums.MetodoPago;
import pe.edu.utp.gestion_cochera.model.Pago;

import java.util.List;

/**
 * Repositorio JPA para la entidad {@link Pago}.
 * Proporciona métodos personalizados para consultar pagos según su estado y método.
 *
 * @author Juan
 * @version 1.0
 */
public interface PagoRepository extends JpaRepository<Pago, Long> {

    /**
     * Obtiene una lista de pagos que tienen el estado especificado.
     *
     * @param estado Estado del pago (PAGADO, PENDIENTE, FALLIDO)
     * @return Lista de pagos con el estado indicado
     */
    List<Pago> findByEstado(EstadoPago estado);

    /**
     * Obtiene una lista de pagos que utilizaron el método especificado.
     *
     * @param metodo Método de pago (YAPE, TARJETA, EFECTIVO)
     * @return Lista de pagos que usaron el método indicado
     */
    List<Pago> findByMetodo(MetodoPago metodo);

    /**
     * Cuenta cuántos pagos se han realizado con el método indicado.
     *
     * @param metodo Método de pago
     * @return Número de pagos realizados con ese método
     */
    long countByMetodo(MetodoPago metodo);

    /**
     * Cuenta cuántos pagos existen con el estado indicado.
     *
     * @param estado Estado del pago
     * @return Número de pagos con ese estado
     */
    long countByEstado(EstadoPago estado);

    /**
     * Obtiene una lista de pagos que coinciden tanto con el estado como con el método especificado.
     *
     * @param estado Estado del pago
     * @param metodo Método de pago
     * @return Lista de pagos con ese estado y método
     */
    List<Pago> findByEstadoAndMetodo(EstadoPago estado, MetodoPago metodo);
}
