package pe.edu.utp.gestion_cochera.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.utp.gestion_cochera.model.TipoVehiculo;
import pe.edu.utp.gestion_cochera.repository.TipoVehiculoRepository;
import pe.edu.utp.gestion_cochera.service.TipoVehiculoService;

import java.util.List;
import java.util.Optional;

@Service
public class TipoVehiculoServiceImpl implements TipoVehiculoService {

    private final TipoVehiculoRepository repo;

    public TipoVehiculoServiceImpl(TipoVehiculoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<TipoVehiculo> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<TipoVehiculo> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public TipoVehiculo save(TipoVehiculo tipoVehiculo) {
        return repo.save(tipoVehiculo);
    }

    @Override
    public Optional<TipoVehiculo> update(Long id, TipoVehiculo nuevoTipo) {
        return repo.findById(id).map(t -> {
            t.setNombre(nuevoTipo.getNombre());
            t.setTarifaHora(nuevoTipo.getTarifaHora());
            return repo.save(t);
        });
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
