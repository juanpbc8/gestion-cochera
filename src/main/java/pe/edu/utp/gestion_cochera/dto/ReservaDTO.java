package pe.edu.utp.gestion_cochera.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import pe.edu.utp.gestion_cochera.enums.EstadoReserva;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaDTO(
        Long reservaId,
        Long clienteId,
        Long vehiculoId,
        Long cocheraId,
        LocalDate fechaReserva,

        @Schema(type = "string", format = "time", example = "11:00")
        @JsonFormat(pattern = "HH:mm")
        LocalTime horaInicio,

        @Schema(type = "string", format = "time", example = "13:00")
        @JsonFormat(pattern = "HH:mm")
        LocalTime horaFin,

        EstadoReserva estado
) {
}
