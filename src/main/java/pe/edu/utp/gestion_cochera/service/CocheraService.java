package pe.edu.utp.gestion_cochera.service;

import pe.edu.utp.gestion_cochera.model.Cochera;

import java.util.List;
import java.util.Optional;

public interface CocheraService {
    List<Cochera> findAll();

    Optional<Cochera> findById(Long id);

    Cochera save(Cochera cochera);

    Optional<Cochera> update(Long id, Cochera nuevaCochera);

    void delete(Long id);
}
