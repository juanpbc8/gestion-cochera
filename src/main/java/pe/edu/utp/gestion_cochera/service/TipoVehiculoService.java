package pe.edu.utp.gestion_cochera.service;

import pe.edu.utp.gestion_cochera.model.TipoVehiculo;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio que define las operaciones para los tipos de vehículos.
 * Contiene los métodos de negocio como registrar, actualizar, eliminar y buscar tipos.
 *
 * @author Stephano
 * @version 1.0
 */
public interface TipoVehiculoService {

    /**
     * Retorna la descripción extendida del tipo de vehículo usando el patrón Decorator.
     *
     * @param id ID del tipo de vehículo.
     * @return Descripción formateada (ej. "Auto – Tarifa: S/5.50")
     */
    String obtenerDescripcionExtendida(Long id);

    /**
     * Obtiene todos los tipos de vehículo registrados.
     *
     * @return Lista de objetos TipoVehiculo.
     */
    List<TipoVehiculo> findAll();

    /**
     * Busca un tipo de vehículo por ID.
     *
     * @param id ID del tipo.
     * @return TipoVehiculo encontrado o vacío si no existe.
     */
    Optional<TipoVehiculo> findById(Long id);

    /**
     * Registra un nuevo tipo de vehículo.
     *
     * @param tipoVehiculo Objeto con los datos del tipo.
     * @return TipoVehiculo registrado.
     */
    TipoVehiculo save(TipoVehiculo tipoVehiculo);

    /**
     * Actualiza un tipo de vehículo existente.
     *
     * @param id        ID del tipo a actualizar.
     * @param nuevoTipo Nuevos datos del tipo.
     * @return TipoVehiculo actualizado o vacío si no existe.
     */
    Optional<TipoVehiculo> update(Long id, TipoVehiculo nuevoTipo);

    /**
     * Elimina un tipo de vehículo por su ID.
     *
     * @param id ID del tipo a eliminar.
     */
    void delete(Long id);
}
