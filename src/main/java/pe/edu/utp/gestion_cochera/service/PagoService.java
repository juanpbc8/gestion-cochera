package pe.edu.utp.gestion_cochera.service;

import pe.edu.utp.gestion_cochera.enums.EstadoPago;
import pe.edu.utp.gestion_cochera.enums.MetodoPago;
import pe.edu.utp.gestion_cochera.model.Pago;

import java.util.List;
import java.util.Optional;

public interface PagoService {

    Pago guardar(Pago pago);

    List<Pago> listar();

    Pago actualizar(Long id, Pago pago);

    void eliminarPorId(Long id);

    Optional<Pago> buscarPorId(Long id);

    // Métodos agregados del repositorio
    List<Pago> buscarPorEstado(EstadoPago estado);

    List<Pago> buscarPorMetodo(MetodoPago metodo);

    long contarPorEstado(EstadoPago estado);

    long contarPorMetodo(MetodoPago metodo);

    List<Pago> buscarPorEstadoYMetodo(EstadoPago estado, MetodoPago metodo);
}