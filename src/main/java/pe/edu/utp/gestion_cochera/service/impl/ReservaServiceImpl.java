package pe.edu.utp.gestion_cochera.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.gestion_cochera.enums.EstadoReserva;
import pe.edu.utp.gestion_cochera.model.Reserva;
import pe.edu.utp.gestion_cochera.repository.ReservaRepository;
import pe.edu.utp.gestion_cochera.service.ReservaService;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository repo;

    public ReservaServiceImpl(ReservaRepository repo) {
        this.repo = repo;
    }

    @Transactional
    @Override
    public Reserva guardar(Reserva reserva) {
        return repo.save(reserva);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Reserva> listar() {
        return repo.findAll();
    }

    @Transactional
    @Override
    public Reserva actualizar(Long id, Reserva reservaActualizada) {
        Reserva reservaExistente = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La reserva con ID " + id + " no existe."));

        reservaExistente.setFechaReserva(reservaActualizada.getFechaReserva());
        reservaExistente.setHoraInicio(reservaActualizada.getHoraInicio());
        reservaExistente.setHoraFin(reservaActualizada.getHoraFin());
        reservaExistente.setEstado(reservaActualizada.getEstado());
        reservaExistente.setCliente(reservaActualizada.getCliente());
        reservaExistente.setVehiculo(reservaActualizada.getVehiculo());
        reservaExistente.setCochera(reservaActualizada.getCochera());
        return repo.save(reservaExistente);
    }

    @Transactional
    @Override
    public void eliminarPorId(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("La reserva con ID " + id + " no existe.");
        }
        repo.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Reserva> buscarPorId(Long id) {
        return repo.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Reserva> buscarPorEstado(EstadoReserva estado) {
        return repo.findByEstado(estado);
    }

    @Transactional(readOnly = true)
    @Override
    public long contarPorEstado(EstadoReserva estado) {
        return repo.countByEstado(estado);
    }
}
