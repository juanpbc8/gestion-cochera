package pe.edu.utp.gestion_cochera.service.patron.singleton;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que implementa el patrón de diseño Singleton.
 * Se encarga de generar un código único de pago utilizando el ID del pago y la fecha actual.
 * Garantiza que solo exista una única instancia de esta clase durante la ejecución del sistema,
 * lo cual es útil cuando se requiere un punto de acceso global y controlado para la generación de códigos.
 *
 * @author Juan
 * @version 1.0
 */
public class GeneradorCodigoPago {
    private static GeneradorCodigoPago instancia;

    private GeneradorCodigoPago() {
    }

    public static GeneradorCodigoPago getInstance() {
        if (instancia == null) {
            instancia = new GeneradorCodigoPago();
        }
        return instancia;
    }

    public String generarCodigoDePago(Long idPago) {
        String fecha = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .replace("/", "");
        return "PAGO-" + String.format("%06d", idPago) + "-" + fecha;
    }
}
