package pe.edu.utp.gestion_cochera.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.gestion_cochera.model.Vehiculo;
import pe.edu.utp.gestion_cochera.service.VehiculoService;

import java.util.List;

/**
 * Controlador REST para gestionar los vehículos.
 * Permite registrar, listar, actualizar y eliminar vehículos asociados a clientes.
 * También permite clonar un vehículo usando el patrón Prototype.
 *
 * @author Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/api/vehiculos")
@Tag(name = "Vehículos", description = "Operaciones relacionadas con la gestión de vehículos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @Operation(summary = "Listar todos los vehículos")
    @GetMapping
    public List<Vehiculo> listar() {
        return vehiculoService.listar();
    }

    @Operation(summary = "Buscar vehículo por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> buscarPorId(@PathVariable Long id) {
        return vehiculoService.buscarPorId(id)
                .map(cliente -> ResponseEntity.ok(cliente))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar un nuevo vehículo")
    @PostMapping
    public Vehiculo guardar(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.guardar(vehiculo);
    }

    @Operation(summary = "Actualizar un vehículo existente")
    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> actualizar(@PathVariable Long id, @RequestBody Vehiculo nuevo) {
        try {
            Vehiculo vehiculoActualizado = vehiculoService.actualizar(id, nuevo);
            return ResponseEntity.ok(vehiculoActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar un vehículo por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        vehiculoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Clonar un vehículo existente por ID (Prototype)")
    @GetMapping("/{id}/clonar")
    public ResponseEntity<Vehiculo> clonarVehiculo(@PathVariable Long id) {
        return vehiculoService.clonarVehiculo(id)
                .map(clon -> ResponseEntity.ok(clon))
                .orElse(ResponseEntity.notFound().build());
    }
}