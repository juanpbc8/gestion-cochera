package pe.edu.utp.gestion_cochera.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.gestion_cochera.model.TipoVehiculo;
import pe.edu.utp.gestion_cochera.service.TipoVehiculoService;

import java.util.List;

/**
 * Controlador REST para gestionar los tipos de vehículos.
 * Permite registrar, listar, actualizar y eliminar tipos de vehículo con sus tarifas por hora.
 *
 * @author Stephano
 * @version 1.0
 */
@RestController
@RequestMapping("/api/tipos")
@Tag(name = "Tipos de Vehículo", description = "Operaciones relacionadas con los tipos de vehículo")
public class TipoVehiculoController {

    private final TipoVehiculoService tipoVehiculoService;

    public TipoVehiculoController(TipoVehiculoService tipoVehiculoService) {
        this.tipoVehiculoService = tipoVehiculoService;
    }

    @Operation(summary = "Listar todos los tipos de vehículo")
    @GetMapping
    public List<TipoVehiculo> listar() {
        return tipoVehiculoService.findAll();
    }

    @Operation(summary = "Buscar tipo de vehículo por ID")
    @GetMapping("/{id}")
    public ResponseEntity<TipoVehiculo> buscarPorId(@PathVariable Long id) {
        return tipoVehiculoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar nuevo tipo de vehículo")
    @PostMapping
    public TipoVehiculo registrar(@RequestBody TipoVehiculo tipoVehiculo) {
        return tipoVehiculoService.save(tipoVehiculo);
    }

    @Operation(summary = "Actualizar tipo de vehículo existente")
    @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculo> actualizar(@PathVariable Long id, @RequestBody TipoVehiculo nuevoTipo) {
        return tipoVehiculoService.update(id, nuevoTipo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar tipo de vehículo por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tipoVehiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Obtener descripción extendida de un tipo de vehículo")
    @GetMapping("/{id}/descripcion")
    public ResponseEntity<String> obtenerDescripcion(@PathVariable Long id) {
        String descripcion = tipoVehiculoService.obtenerDescripcionExtendida(id);
        if (descripcion.equals("Tipo de vehículo no encontrado.")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(descripcion);
    }
}
