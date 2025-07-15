package pe.edu.utp.gestion_cochera.service;

import pe.edu.utp.gestion_cochera.model.Cliente;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio que define las operaciones para los clientes.
 * Contiene los métodos de negocio como registrar, actualizar, eliminar y buscar.
 *
 * @author Joel
 * @version 1.0
 */
public interface ClienteService {

    /**
     * Guarda un nuevo cliente en el sistema.
     *
     * @param cliente El cliente a registrar.
     * @return El cliente guardado.
     */
    Cliente guardar(Cliente cliente);

    /**
     * Lista todos los clientes registrados en el sistema.
     *
     * @return Una lista con todos los clientes.
     */
    List<Cliente> listar();

    /**
     * Actualiza los datos de un cliente existente.
     *
     * @param id      El ID del cliente a actualizar.
     * @param cliente Los nuevos datos del cliente.
     * @return El cliente actualizado.
     */
    Cliente actualizar(Long id, Cliente cliente);

    /**
     * Elimina un cliente según su ID.
     *
     * @param id El ID del cliente a eliminar.
     */
    void eliminarPorId(Long id);

    /**
     * Busca un cliente por su ID.
     *
     * @param id El ID del cliente a buscar.
     * @return Un Optional con el cliente encontrado, o vacío si no existe.
     */
    Optional<Cliente> buscarPorId(Long id);
}
