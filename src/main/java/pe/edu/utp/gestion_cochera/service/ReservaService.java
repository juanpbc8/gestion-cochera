package pe.edu.utp.gestion_cochera.service;

import pe.edu.utp.gestion_cochera.dto.ReservaDTO;
import pe.edu.utp.gestion_cochera.enums.EstadoReserva;
import pe.edu.utp.gestion_cochera.model.Reserva;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio que define las operaciones para las reservas.
 * Permite registrar, listar, actualizar, eliminar y consultar reservas según distintos criterios.
 * Utiliza objetos DTO para facilitar la transferencia de datos entre capas.
 *
 * @author Juan
 * @version 1.0
 */
public interface ReservaService {

    /**
     * Guarda una nueva reserva en el sistema a partir de un DTO.
     *
     * @param dto El objeto DTO con los datos de la reserva.
     * @return La entidad Reserva guardada.
     */
    Reserva guardar(ReservaDTO dto);

    /**
     * Lista todas las reservas registradas.
     *
     * @return Una lista con todas las reservas.
     */
    List<Reserva> listar();

    /**
     * Actualiza una reserva existente con los datos proporcionados en un DTO.
     *
     * @param id  El ID de la reserva a actualizar.
     * @param dto El objeto DTO con los nuevos datos de la reserva.
     * @return La entidad Reserva actualizada.
     */
    Reserva actualizar(Long id, ReservaDTO dto);

    /**
     * Elimina una reserva por su ID.
     *
     * @param id El ID de la reserva a eliminar.
     */
    void eliminarPorId(Long id);

    /**
     * Busca una reserva por su ID.
     *
     * @param id El ID de la reserva a buscar.
     * @return Un Optional con la reserva encontrada, o vacío si no existe.
     */
    Optional<Reserva> buscarPorId(Long id);

    /**
     * Busca todas las reservas que coincidan con un estado específico.
     *
     * @param estado El estado de la reserva a filtrar.
     * @return Una lista de reservas que coincidan con el estado.
     */
    List<Reserva> buscarPorEstado(EstadoReserva estado);

    /**
     * Cuenta la cantidad de reservas que se encuentran en un estado específico.
     *
     * @param estado El estado de la reserva a contar.
     * @return El número de reservas con ese estado.
     */
    long contarPorEstado(EstadoReserva estado);
}
