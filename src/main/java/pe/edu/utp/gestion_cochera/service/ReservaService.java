package pe.edu.utp.gestion_cochera.service;

import pe.edu.utp.gestion_cochera.enums.EstadoPago;
import pe.edu.utp.gestion_cochera.enums.EstadoReserva;
import pe.edu.utp.gestion_cochera.model.Cliente;
import pe.edu.utp.gestion_cochera.model.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {

    Reserva guardar(Reserva reserva);

    List<Reserva> listar();

    Reserva actualizar(Long id, Reserva reserva);

    void eliminarPorId(Long id);

    Optional<Reserva> buscarPorId(Long id);

    //Metodos agregados del repositorio

    List<Reserva> buscarPorEstado(EstadoReserva estado);

    long contarPorEstado(EstadoReserva estado);

    List<Reserva> buscarPorCliente(Cliente cliente);

}
