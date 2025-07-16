package pe.edu.utp.gestion_cochera.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.gestion_cochera.model.Cochera;
import pe.edu.utp.gestion_cochera.service.CocheraService;

import java.util.List;

/**
 * Controlador REST para gestionar las cocheras.
 * Permite registrar, listar, actualizar y eliminar cocheras del sistema.
 *
 * @author Stephano
 * @version 1.0
 */
@RestController
@RequestMapping("/api/cocheras")
@Tag(name = "Cocheras", description = "Operaciones relacionadas a la gestión de cocheras")
public class CocheraController {
    private final CocheraService service;

    public CocheraController(CocheraService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todas las cocheras")
    @GetMapping
    public List<Cochera> listarCocheras() {
        return service.findAll();
    }

    @Operation(summary = "Obtener cochera por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Cochera> obtenerPorId(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar nueva cochera")
    @PostMapping
    public Cochera registrar(@RequestBody Cochera cochera) {
        return service.save(cochera);
    }

    @Operation(summary = "Actualizar cochera existente")
    @PutMapping("/{id}")
    public ResponseEntity<Cochera> actualizar(@PathVariable Long id, @RequestBody Cochera nuevaCochera) {
        return service.update(id, nuevaCochera)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar cochera por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
