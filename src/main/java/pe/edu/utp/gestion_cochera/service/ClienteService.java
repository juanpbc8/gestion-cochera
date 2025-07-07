package pe.edu.utp.gestion_cochera.service;

import pe.edu.utp.gestion_cochera.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Cliente guardar(Cliente cliente);

    List<Cliente> listar();

    Cliente actualizar(Long id, Cliente cliente);

    void eliminarPorId(Long id);

    Optional<Cliente> buscarPorId(Long id);
}
