package pe.edu.utp.gestion_cochera.dto;

import pe.edu.utp.gestion_cochera.enums.EstadoPago;
import pe.edu.utp.gestion_cochera.enums.MetodoPago;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PagoDTO(
        Long pagoId,
        Long reservaId,
        BigDecimal monto,
        MetodoPago metodo,
        LocalDate fechaPago,
        EstadoPago estado
) {
}
