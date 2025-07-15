package pe.edu.utp.gestion_cochera.service;

import pe.edu.utp.gestion_cochera.dto.PagoDTO;
import pe.edu.utp.gestion_cochera.enums.EstadoPago;
import pe.edu.utp.gestion_cochera.enums.MetodoPago;
import pe.edu.utp.gestion_cochera.model.Pago;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio que define las operaciones para los pagos.
 * Permite registrar, listar, actualizar, eliminar y consultar pagos según su estado y método.
 * Utiliza objetos DTO para la transferencia de datos entre capas.
 *
 * @author Juan
 * @version 1.0
 */
public interface PagoService {

    /**
     * Guarda un nuevo pago en el sistema a partir de un DTO.
     *
     * @param dto El objeto DTO con los datos del pago.
     * @return La entidad Pago guardada.
     */
    Pago guardar(PagoDTO dto);

    /**
     * Lista todos los pagos registrados.
     *
     * @return Una lista con todos los pagos.
     */
    List<Pago> listar();

    /**
     * Actualiza un pago existente con los datos proporcionados en un DTO.
     *
     * @param id  El ID del pago a actualizar.
     * @param dto El objeto DTO con los nuevos datos del pago.
     * @return La entidad Pago actualizada.
     */
    Pago actualizar(Long id, PagoDTO dto);

    /**
     * Elimina un pago por su ID.
     *
     * @param id El ID del pago a eliminar.
     */
    void eliminarPorId(Long id);

    /**
     * Busca un pago por su ID.
     *
     * @param id El ID del pago a buscar.
     * @return Un Optional con el pago encontrado, o vacío si no existe.
     */
    Optional<Pago> buscarPorId(Long id);

    /**
     * Busca los pagos que tengan un estado específico.
     *
     * @param estado El estado de pago a filtrar.
     * @return Una lista de pagos con el estado indicado.
     */
    List<Pago> buscarPorEstado(EstadoPago estado);

    /**
     * Busca los pagos realizados con un método específico.
     *
     * @param metodo El método de pago a filtrar.
     * @return Una lista de pagos que utilicen ese método.
     */
    List<Pago> buscarPorMetodo(MetodoPago metodo);

    /**
     * Cuenta la cantidad de pagos que se encuentran en un estado específico.
     *
     * @param estado El estado de pago a contar.
     * @return El número de pagos con ese estado.
     */
    long contarPorEstado(EstadoPago estado);

    /**
     * Cuenta la cantidad de pagos realizados con un método específico.
     *
     * @param metodo El método de pago a contar.
     * @return El número de pagos realizados con ese método.
     */
    long contarPorMetodo(MetodoPago metodo);

    /**
     * Busca los pagos que coincidan con un estado y método de pago específicos.
     *
     * @param estado El estado del pago.
     * @param metodo El método de pago.
     * @return Una lista de pagos que coincidan con ambos criterios.
     */
    List<Pago> buscarPorEstadoYMetodo(EstadoPago estado, MetodoPago metodo);
}