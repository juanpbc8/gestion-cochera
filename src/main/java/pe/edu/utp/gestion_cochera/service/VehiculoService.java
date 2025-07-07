package pe.edu.utp.gestion_cochera.service;

import pe.edu.utp.gestion_cochera.model.Pago;
import pe.edu.utp.gestion_cochera.model.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface VehiculoService {
    Vehiculo guardar(Vehiculo vehiculo);

    List<Vehiculo> listar();

    Vehiculo actualizar(Long id, Vehiculo vehiculo);

    void eliminarPorId(Long id);

    Optional<Vehiculo> buscarPorId(Long id);
}
