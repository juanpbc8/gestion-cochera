package pe.edu.utp.gestion_cochera.service;

import pe.edu.utp.gestion_cochera.model.Vehiculo;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio que define las operaciones para los vehículos.
 * Contiene los métodos de negocio como registrar, actualizar, eliminar y buscar.
 *
 * @author Joel
 * @version 1.0
 */
public interface VehiculoService {

    /**
     * Guarda un nuevo vehiculo en la base de datos
     *
     * @param vehiculo Objeto vehiculo que se desea guardar
     * @return El vehículo guardado con su ID generado
     */
    Vehiculo guardar(Vehiculo vehiculo);


    /**
     * Lista todos los vehículos registrados
     *
     * @return lista de objetos Vehiculo
     */
    List<Vehiculo> listar();

    /**
     * Actualiza los datos de un vehiculo existente según su ID
     *
     * @param id       ID del vehículo que se desea actualizar
     * @param vehiculo Objeto vehículo con los nuevos datos
     * @return el vehículo actualizado
     */
    Vehiculo actualizar(Long id, Vehiculo vehiculo);

    /**
     * Elimina un vehículo de la base de datos por su ID
     *
     * @param id ID del vehículo a eliminar
     */
    void eliminarPorId(Long id);


    /**
     * Clona un vehículo existente usando el patrón Prototype
     *
     * @param id ID del vehículo a clonar
     * @return Optional con el vehículo clonado si existe, o vacío si no se encuentra
     */
    Optional<Vehiculo> clonarVehiculo(Long id);

    /**
     * Buscar un vehiculo por su id
     *
     * @param id ID del vehiculo a buscar
     * @return Un Optional que contiene el vehículo si se encuentra, o vacio si no existe
     */
    Optional<Vehiculo> buscarPorId(Long id);
}
