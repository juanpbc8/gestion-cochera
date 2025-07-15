package pe.edu.utp.gestion_cochera.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.gestion_cochera.model.Pago;
import pe.edu.utp.gestion_cochera.service.PagoService;

import java.util.List;

@RestController
@RequestMapping("api/pagos")
public class PagoController {
    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todos los pagos")
    @GetMapping
    public ResponseEntity<List<Pago>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @Operation(summary = "Registrar un nuevo pago")
    @PostMapping
    public ResponseEntity<Pago> guardar(@RequestBody @Valid Pago pago, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.guardar(pago));
    }
}
