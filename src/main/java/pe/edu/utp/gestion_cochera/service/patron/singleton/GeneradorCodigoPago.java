package pe.edu.utp.gestion_cochera.service.patron.singleton;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GeneradorCodigoPago {
    private static GeneradorCodigoPago instancia;

    private GeneradorCodigoPago() {
    }

    public static GeneradorCodigoPago getInstance() {
        return instancia == null ? new GeneradorCodigoPago() : instancia;
    }

    public String generarCodigoDePago(Long idPago) {
        String fecha = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .replace("/", "");
        return "PAGO-" + String.format("%06d", idPago) + "-" + fecha;
    }
}
