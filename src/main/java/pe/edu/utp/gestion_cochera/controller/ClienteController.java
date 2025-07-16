package pe.edu.utp.gestion_cochera.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.gestion_cochera.model.Cliente;
import pe.edu.utp.gestion_cochera.service.ClienteService;

import java.util.List;

/**
 * Controlador REST para la gestión de clientes.
 * Proporciona endpoints para registrar, actualizar, eliminar, listar y obtener clientes.
 *
 * @author Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes", description = "Operaciones relacionadas con la gestión de clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(summary = "Listar todos los clientes")
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @Operation(summary = "Obtener cliente por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar un nuevo cliente")
    @PostMapping
    public Cliente registrar(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    @Operation(summary = "Actualizar un cliente existente")
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @RequestBody Cliente nuevo) {
        try {
            Cliente clienteActualizado = clienteService.actualizar(id, nuevo);
            return ResponseEntity.ok(clienteActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar cliente por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}