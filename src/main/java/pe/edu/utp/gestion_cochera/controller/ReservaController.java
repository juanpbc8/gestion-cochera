package pe.edu.utp.gestion_cochera.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.gestion_cochera.dto.ReservaDTO;
import pe.edu.utp.gestion_cochera.enums.EstadoReserva;
import pe.edu.utp.gestion_cochera.model.Reserva;
import pe.edu.utp.gestion_cochera.service.ReservaService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Controlador REST para la gestión de reservas.
 * Expone endpoints para registrar, actualizar, eliminar, buscar y listar reservas
 * utilizando DTO. Además, permite filtrar y contar reservas por estado.
 * <p>
 * Este controlador actúa como intermediario entre el cliente y la capa de servicio,
 * facilitando la conversión entre entidades y DTO.
 *
 * @author Juan
 * @version 1.0
 */
@RestController
@RequestMapping("/api/reservas")
@Tag(name = "Reservas", description = "Operaciones relacionadas con la gestión de reservas")
public class ReservaController {
    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todas las reservas")
    @GetMapping
    public ResponseEntity<List<ReservaDTO>> listar() {
        List<ReservaDTO> dtos = service.listar().stream()
                .map(this::toDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Registrar una nueva reserva")
    @PostMapping
    public ResponseEntity<ReservaDTO> registrar(@RequestBody ReservaDTO dto) {
        Reserva reservaSave = service.guardar(dto);
        ReservaDTO dtoResponse = toDTO(reservaSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoResponse);
    }

    @Operation(summary = "Buscar reserva por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> buscarPorId(@PathVariable Long id) {
        Optional<Reserva> reservaOpt = service.buscarPorId(id);
        return reservaOpt.map(r -> ResponseEntity.ok(toDTO(r)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Actualizar una reserva por ID")
    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> actualizar(@PathVariable Long id, @RequestBody ReservaDTO dto) {
        try {
            Reserva reservaUpdated = service.actualizar(id, dto);
            return ResponseEntity.ok(toDTO(reservaUpdated));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Eliminar una reserva por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<Reserva> reservaOpt = service.buscarPorId(id);
        if (reservaOpt.isPresent()) {
            service.eliminarPorId(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Operation(summary = "Buscar reservas por estado")
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<ReservaDTO>> buscarPorEstado(@PathVariable EstadoReserva estado) {
        List<ReservaDTO> dtos = service.buscarPorEstado(estado)
                .stream()
                .map(this::toDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Contar reservas por estado")
    @GetMapping("/estado/{estado}/count")
    public ResponseEntity<Long> contarPorEstado(@PathVariable EstadoReserva estado) {
        return ResponseEntity.ok(service.contarPorEstado(estado));
    }

    /**
     * Convierte una entidad {@link Reserva} en un {@link ReservaDTO}
     * para ser enviada como respuesta al cliente.
     *
     * @param r La entidad Reserva original.
     * @return El objeto DTO equivalente.
     */
    private ReservaDTO toDTO(Reserva r) {
        return new ReservaDTO(
                r.getId(),
                r.getCliente().getId(),
                r.getVehiculo().getId(),
                r.getCochera().getId(),
                r.getFechaReserva(),
                r.getHoraInicio(),
                r.getHoraFin(),
                r.getEstado()
        );
    }
}
