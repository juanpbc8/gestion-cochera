package pe.edu.utp.gestion_cochera.service;

import pe.edu.utp.gestion_cochera.model.TipoVehiculo;

import java.util.List;
import java.util.Optional;

public interface TipoVehiculoService {
    List<TipoVehiculo> findAll();

    Optional<TipoVehiculo> findById(Long id);

    TipoVehiculo save(TipoVehiculo tipoVehiculo);

    Optional<TipoVehiculo> update(Long id, TipoVehiculo nuevoTipo);

    void delete(Long id);
}
