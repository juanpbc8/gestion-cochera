package pe.edu.utp.gestion_cochera.service;

import pe.edu.utp.gestion_cochera.model.Cochera;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio que define las operaciones disponibles para las cocheras.
 * Contiene los métodos de negocio como listar, registrar, actualizar y eliminar.
 *
 * @author Stephano
 * @version 1.0
 */
public interface CocheraService {
    
    /**
     * Obtiene la lista de todas las cocheras registradas.
     *
     * @return Lista de objetos Cochera.
     */
    List<Cochera> findAll();

    /**
     * Busca una cochera por su ID.
     *
     * @param id ID de la cochera.
     * @return Cochera encontrada o vacía si no existe.
     */
    Optional<Cochera> findById(Long id);

    /**
     * Registra una nueva cochera.
     *
     * @param cochera Objeto Cochera con los datos a guardar.
     * @return Cochera registrada.
     */
    Cochera save(Cochera cochera);

    /**
     * Actualiza una cochera existente.
     *
     * @param id           ID de la cochera a actualizar.
     * @param nuevaCochera Nuevos datos de la cochera.
     * @return Cochera actualizada o vacía si no existe.
     */
    Optional<Cochera> update(Long id, Cochera nuevaCochera);

    /**
     * Elimina una cochera por su ID.
     *
     * @param id ID de la cochera a eliminar.
     */
    void delete(Long id);
}
