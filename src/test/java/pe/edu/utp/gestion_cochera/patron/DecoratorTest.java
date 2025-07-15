package pe.edu.utp.gestion_cochera.patron;

import org.junit.jupiter.api.Test;
import pe.edu.utp.gestion_cochera.model.TipoVehiculo;
import pe.edu.utp.gestion_cochera.service.patron.decorator.TipoVehiculoConDescripcion;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Prueba unitaria para validar el funcionamiento del patrón Decorator
 * aplicado a la clase {@link TipoVehiculoConDescripcion}.
 * Se verifica que el decorador agregue correctamente una descripción
 * adicional al tipo de vehículo incluyendo su nombre y tarifa por hora.
 *
 * @author Stephano
 * @version 1.0
 */
public class DecoratorTest {
    @Test
    void testDescripcionConTarifa() {
        TipoVehiculo tipo = new TipoVehiculo();
        tipo.setNombre("Auto");
        tipo.setTarifaHora(new BigDecimal("5.50"));

        TipoVehiculoConDescripcion decorado = new TipoVehiculoConDescripcion(tipo);
        String descripcion = decorado.obtenerDescripcion();

        assertTrue(descripcion.contains("Auto"));
        assertTrue(descripcion.contains("5.50"));
    }
}
