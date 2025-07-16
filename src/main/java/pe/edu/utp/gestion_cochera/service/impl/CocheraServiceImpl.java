package pe.edu.utp.gestion_cochera.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.utp.gestion_cochera.model.Cochera;
import pe.edu.utp.gestion_cochera.repository.CocheraRepository;
import pe.edu.utp.gestion_cochera.service.CocheraService;

import java.util.List;
import java.util.Optional;

/**
 * Implementación de la interfaz CocheraService.
 * Utiliza CocheraRepository para interactuar con la base de datos.
 * Aplica la lógica de negocio relacionada a cocheras.
 *
 * @author Stephano
 * @version 1.0
 */
@Service
public class CocheraServiceImpl implements CocheraService {

    private final CocheraRepository cocheraRepository;

    public CocheraServiceImpl(CocheraRepository cocheraRepository) {
        this.cocheraRepository = cocheraRepository;
    }

    @Override
    public List<Cochera> findAll() {
        return cocheraRepository.findAll();
    }

    @Override
    public Optional<Cochera> findById(Long id) {
        return cocheraRepository.findById(id);
    }
    
    @Override
    public Cochera save(Cochera cochera) {
        return cocheraRepository.save(cochera);
    }

    @Override
    public Optional<Cochera> update(Long id, Cochera nuevaCochera) {
        return cocheraRepository.findById(id).map(c -> {
            c.setNombre(nuevaCochera.getNombre());
            c.setDireccion(nuevaCochera.getDireccion());
            c.setCapacidadTotal(nuevaCochera.getCapacidadTotal());
            c.setDisponibilidadActual(nuevaCochera.getDisponibilidadActual());
            return cocheraRepository.save(c);
        });
    }

    @Override
    public void delete(Long id) {
        cocheraRepository.deleteById(id);
    }
}
