package pe.edu.utp.gestion_cochera.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.gestion_cochera.dto.PagoDTO;
import pe.edu.utp.gestion_cochera.model.Pago;
import pe.edu.utp.gestion_cochera.service.PagoService;

import java.util.List;

/**
 * Controlador REST para la gestión de pagos.
 * Permite registrar nuevos pagos y listar todos los pagos registrados.
 * Utiliza objetos DTO para la transferencia de datos entre el cliente y el sistema.
 *
 * @author Juan
 * @version 1.0
 */
@RestController
@RequestMapping("/api/pagos")
@Tag(name = "Pagos", description = "Operaciones relacionadas con el registro y consulta de pagos")
public class PagoController {
    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todos los pagos")
    @GetMapping
    public ResponseEntity<List<PagoDTO>> listar() {
        List<PagoDTO> dtos = service.listar().stream()
                .map(this::toDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Registrar un nuevo pago")
    @PostMapping
    public ResponseEntity<PagoDTO> guardar(@RequestBody PagoDTO dto) {
        Pago pagoSave = service.guardar(dto);
        PagoDTO dtoResponse = toDTO(pagoSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoResponse);
    }

    /**
     * Convierte una entidad {@link Pago} en su representación {@link PagoDTO}
     * para ser enviada como respuesta al cliente.
     *
     * @param p La entidad Pago original.
     * @return El objeto DTO equivalente.
     */
    private PagoDTO toDTO(Pago p) {
        return new PagoDTO(
                p.getId(),
                p.getReserva().getId(),
                p.getMonto(),
                p.getMetodo(),
                p.getFechaPago(),
                p.getEstado());
    }
}
