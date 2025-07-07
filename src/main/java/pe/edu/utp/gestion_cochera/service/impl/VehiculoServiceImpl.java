package pe.edu.utp.gestion_cochera.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.utp.gestion_cochera.model.Vehiculo;
import pe.edu.utp.gestion_cochera.repository.VehiculoRepository;
import pe.edu.utp.gestion_cochera.service.VehiculoService;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehiculoService {
    private final VehiculoRepository repo;

    public VehiculoServiceImpl(VehiculoRepository repo) {
        this.repo = repo;
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
