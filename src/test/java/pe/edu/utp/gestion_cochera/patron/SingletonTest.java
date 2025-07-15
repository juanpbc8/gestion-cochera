package pe.edu.utp.gestion_cochera.patron;

import org.junit.jupiter.api.Test;
import pe.edu.utp.gestion_cochera.service.patron.singleton.GeneradorCodigoPago;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para verificar el correcto funcionamiento del patrón Singleton
 * aplicado en la clase {@link GeneradorCodigoPago}.
 * Se valida que la instancia sea única en todo el sistema y que el formato del código
 * generado cumpla con el patrón esperado.
 *
 * @author Juan
 * @version 1.0
 */
public class SingletonTest {
    @Test
    void testInstanciaSingleton() {
        GeneradorCodigoPago instancia1 = GeneradorCodigoPago.getInstance();
        GeneradorCodigoPago instancia2 = GeneradorCodigoPago.getInstance();

        assertSame(instancia1, instancia2, "Debe devolver la misma instancia");
    }

    @Test
    void testFormatoCodigoPago() {
        GeneradorCodigoPago generador = GeneradorCodigoPago.getInstance();
        String codigo = generador.generarCodigoDePago(42L);

        assertTrue(codigo.startsWith("PAGO-000042-"), "El código debe iniciar con PAGO- seguido del ID con ceros y la fecha");
        assertEquals(20, codigo.length(), "El código debe tener exactamente 20 caracteres");
    }
}
