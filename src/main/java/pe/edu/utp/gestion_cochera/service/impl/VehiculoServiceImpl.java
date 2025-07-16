package pe.edu.utp.gestion_cochera.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.utp.gestion_cochera.model.Vehiculo;
import pe.edu.utp.gestion_cochera.repository.VehiculoRepository;
import pe.edu.utp.gestion_cochera.service.VehiculoService;
import pe.edu.utp.gestion_cochera.service.patron.prototype.VehiculoPrototipo;

import java.util.List;
import java.util.Optional;

/**
 * Implementación de la interfaz VehiculoService.
 * Utiliza VehiculoRepository para interactuar con la base de datos.
 * Aplica la lógica de negocio relacionada con vehiculos.
 *
 * @author Joel
 * @version 1.0
 */
@Service
public class VehiculoServiceImpl implements VehiculoService {
    private final VehiculoRepository repo;

    public VehiculoServiceImpl(VehiculoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Optional<Vehiculo> clonarVehiculo(Long id) {
        return repo.findById(id)
                .map(original -> {
                    VehiculoPrototipo prototipo = new VehiculoPrototipo(original);
                    Vehiculo clon = prototipo.clonar();
                    clon.setPlaca(clon.getPlaca() + "-CLON");
                    return repo.save(clon);
                });
    }

    @Override
    public Vehiculo guardar(Vehiculo vehiculo) {
        return repo.save(vehiculo);
    }

    @Override
    public List<Vehiculo> listar() {
        return repo.findAll();
    }

    @Override
    public Vehiculo actualizar(Long id, Vehiculo vehiculoActualizado) {
        Vehiculo vehiculoExistente = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El vehiculo con ID " + id + " no existe."));

        vehiculoExistente.setColor(vehiculoActualizado.getColor());
        vehiculoExistente.setMarca(vehiculoActualizado.getMarca());
        vehiculoExistente.setPlaca(vehiculoActualizado.getPlaca());
        vehiculoExistente.setModelo(vehiculoActualizado.getModelo());
        vehiculoExistente.setPropietario(vehiculoActualizado.getPropietario());
        vehiculoExistente.setTipo(vehiculoActualizado.getTipo());

        return repo.save(vehiculoExistente);
    }

    @Override
    public void eliminarPorId(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("El vehiculo con ID " + id + " no existe.");
        }
        repo.deleteById(id);
    }

    @Override
    public Optional<Vehiculo> buscarPorId(Long id) {
        return repo.findById(id);
    }
}
