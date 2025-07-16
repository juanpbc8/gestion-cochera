package pe.edu.utp.gestion_cochera.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.utp.gestion_cochera.model.Cliente;
import pe.edu.utp.gestion_cochera.repository.ClienteRepository;
import pe.edu.utp.gestion_cochera.service.ClienteService;

import java.util.List;
import java.util.Optional;

/**
 * Implementación de la interfaz ClienteService.
 * Utiliza ClienteRepository para interactuar con la base de datos.
 * Aplica la lógica de negocio relacionada con clientes.
 *
 * @author Joel
 * @version 1.0
 */
@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository repo;

    public ClienteServiceImpl(ClienteRepository repo) {
        this.repo = repo;
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return repo.save(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return repo.findAll();
    }

    @Override
    public Cliente actualizar(Long id, Cliente clienteActualizado) {
        Cliente clienteExistente = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El cliente con ID " + id + " no existe."));

        clienteExistente.setNombreCompleto(clienteActualizado.getNombreCompleto());
        clienteExistente.setDni(clienteActualizado.getDni());
        clienteExistente.setEmail(clienteActualizado.getEmail());
        clienteExistente.setTelefono(clienteActualizado.getTelefono());

        return repo.save(clienteExistente);
    }

    @Override
    public void eliminarPorId(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("El cliente con ID " + id + " no existe.");
        }
        repo.deleteById(id);
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return repo.findById(id);
    }
}
