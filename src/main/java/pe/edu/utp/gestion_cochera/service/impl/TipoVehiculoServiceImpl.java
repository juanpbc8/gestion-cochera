package pe.edu.utp.gestion_cochera.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.utp.gestion_cochera.model.TipoVehiculo;
import pe.edu.utp.gestion_cochera.repository.TipoVehiculoRepository;
import pe.edu.utp.gestion_cochera.service.TipoVehiculoService;
import pe.edu.utp.gestion_cochera.service.patron.decorator.TipoVehiculoComponent;
import pe.edu.utp.gestion_cochera.service.patron.decorator.TipoVehiculoConDescripcion;

import java.util.List;
import java.util.Optional;

/**
 * Implementación de la interfaz TipoVehiculoService.
 * Maneja la lógica de negocio para tipos de vehículo, usando el repositorio correspondiente.
 *
 * @author Stephano
 * @version 1.0
 */
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
    
    @Override
    public String obtenerDescripcionExtendida(Long id) {
        Optional<TipoVehiculo> tipoOpt = repo.findById(id);
        if (tipoOpt.isPresent()) {
            TipoVehiculo tipo = tipoOpt.get();
            TipoVehiculoComponent decorado = new TipoVehiculoConDescripcion(tipo);
            return decorado.obtenerDescripcion();
        }
        return "Tipo de vehículo no encontrado.";
    }
}
