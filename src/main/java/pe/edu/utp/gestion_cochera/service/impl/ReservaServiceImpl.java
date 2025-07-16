package pe.edu.utp.gestion_cochera.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.gestion_cochera.dto.ReservaDTO;
import pe.edu.utp.gestion_cochera.enums.EstadoReserva;
import pe.edu.utp.gestion_cochera.model.Cliente;
import pe.edu.utp.gestion_cochera.model.Cochera;
import pe.edu.utp.gestion_cochera.model.Reserva;
import pe.edu.utp.gestion_cochera.model.Vehiculo;
import pe.edu.utp.gestion_cochera.repository.ReservaRepository;
import pe.edu.utp.gestion_cochera.service.ReservaService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Implementación del servicio {@link ReservaService} que gestiona la lógica de negocio
 * relacionada a las reservas de cocheras. Utiliza un repositorio para acceder a los datos
 * y métodos auxiliares internos para convertir entre DTOs y entidades.
 *
 * @author Juan
 * @version 1.0
 */
@Service
public class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository repo;

    public ReservaServiceImpl(ReservaRepository repo) {
        this.repo = repo;
    }

    @Transactional
    @Override
    public Reserva guardar(ReservaDTO dto) {
        return repo.save(toEntity(dto));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Reserva> listar() {
        return repo.findAll();
    }

    @Transactional
    @Override
    public Reserva actualizar(Long id, ReservaDTO dto) {
        Reserva r = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Reserva no encontrada con ID: " + id));
        return repo.save(toEntity(r, dto));
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

    /**
     * Convierte un objeto {@link ReservaDTO} a una entidad {@link Reserva} lista para ser persistida.
     * Este método es utilizado durante el registro de nuevas reservas.
     *
     * @param dto El DTO con los datos de la reserva.
     * @return La entidad Reserva correspondiente.
     */
    private Reserva toEntity(ReservaDTO dto) {
        Reserva r = new Reserva();

        Cliente cliente = new Cliente();
        cliente.setId(dto.clienteId());

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(dto.vehiculoId());

        Cochera cochera = new Cochera();
        cochera.setId(dto.cocheraId());

        r.setCliente(cliente);
        r.setVehiculo(vehiculo);
        r.setCochera(cochera);
        r.setFechaReserva(dto.fechaReserva());
        r.setHoraInicio(dto.horaInicio());
        r.setHoraFin(dto.horaFin());
        r.setEstado(dto.estado());
        return r;
    }

    /**
     * Actualiza los datos de una entidad {@link Reserva} existente a partir de un {@link ReservaDTO}.
     * Este método conserva la instancia original pero sobrescribe sus atributos.
     *
     * @param r   La entidad Reserva que se desea actualizar.
     * @param dto El DTO con los nuevos datos.
     * @return La entidad Reserva con los valores actualizados.
     */
    private Reserva toEntity(Reserva r, ReservaDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setId(dto.clienteId());

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(dto.vehiculoId());

        Cochera cochera = new Cochera();
        cochera.setId(dto.cocheraId());

        r.setCliente(cliente);
        r.setVehiculo(vehiculo);
        r.setCochera(cochera);
        r.setFechaReserva(dto.fechaReserva());
        r.setHoraInicio(dto.horaInicio());
        r.setHoraFin(dto.horaFin());
        r.setEstado(dto.estado());
        return r;
    }
}
