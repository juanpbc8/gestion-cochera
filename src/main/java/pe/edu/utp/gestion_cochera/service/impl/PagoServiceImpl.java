package pe.edu.utp.gestion_cochera.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.gestion_cochera.enums.EstadoPago;
import pe.edu.utp.gestion_cochera.enums.MetodoPago;
import pe.edu.utp.gestion_cochera.model.Pago;
import pe.edu.utp.gestion_cochera.repository.PagoRepository;
import pe.edu.utp.gestion_cochera.service.PagoService;
import pe.edu.utp.gestion_cochera.service.patron.singleton.GeneradorCodigoPago;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {
    private final PagoRepository repo;

    public PagoServiceImpl(PagoRepository repo) {
        this.repo = repo;
    }

    @Transactional
    @Override
    public Pago guardar(Pago pago) {
        Pago pagoGuardado = repo.save(pago);
        String codigo = GeneradorCodigoPago.getInstance().generarCodigoDePago(pagoGuardado.getId());
        pagoGuardado.setCodigo(codigo);
        return repo.save(pagoGuardado);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pago> listar() {
        return repo.findAll();
    }

    @Transactional
    @Override
    public Pago actualizar(Long id, Pago pagoActualizado) {
        Pago pagoExistente = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El pago con ID " + id + " no existe."));

        pagoExistente.setMonto(pagoActualizado.getMonto());
        pagoExistente.setMetodo(pagoActualizado.getMetodo());
        pagoExistente.setFechaPago(pagoActualizado.getFechaPago());
        pagoExistente.setEstado(pagoActualizado.getEstado());
        pagoExistente.setReserva(pagoActualizado.getReserva());

        return repo.save(pagoExistente);
    }

    @Transactional
    @Override
    public void eliminarPorId(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("El pago con ID " + id + " no existe.");
        }
        repo.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Pago> buscarPorId(Long id) {
        return repo.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pago> buscarPorEstado(EstadoPago estado) {
        return repo.findByEstado(estado);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pago> buscarPorMetodo(MetodoPago metodo) {
        return repo.findByMetodo(metodo);
    }

    @Transactional(readOnly = true)
    @Override
    public long contarPorEstado(EstadoPago estado) {
        return repo.countByEstado(estado);
    }

    @Transactional(readOnly = true)
    @Override
    public long contarPorMetodo(MetodoPago metodo) {
        return repo.countByMetodo(metodo);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pago> buscarPorEstadoYMetodo(EstadoPago estado, MetodoPago metodo) {
        return repo.findByEstadoAndMetodo(estado, metodo);
    }
}
