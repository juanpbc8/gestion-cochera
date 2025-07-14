package pe.edu.utp.gestion_cochera;

import org.junit.jupiter.api.Test;
import pe.edu.utp.gestion_cochera.service.patron.singleton.GeneradorCodigoPago;

import static org.junit.jupiter.api.Assertions.*;

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
