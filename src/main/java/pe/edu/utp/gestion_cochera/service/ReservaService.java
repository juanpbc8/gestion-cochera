package pe.edu.utp.gestion_cochera.service;

import pe.edu.utp.gestion_cochera.dto.ReservaDTO;
import pe.edu.utp.gestion_cochera.enums.EstadoPago;
import pe.edu.utp.gestion_cochera.enums.EstadoReserva;
import pe.edu.utp.gestion_cochera.model.Cliente;
import pe.edu.utp.gestion_cochera.model.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {

    Reserva guardar(ReservaDTO dto);

    List<Reserva> listar();

    Reserva actualizar(Long id, ReservaDTO dto);

    void eliminarPorId(Long id);

    Optional<Reserva> buscarPorId(Long id);

    //Metodos agregados del repositorio

    List<Reserva> buscarPorEstado(EstadoReserva estado);

    long contarPorEstado(EstadoReserva estado);
}
