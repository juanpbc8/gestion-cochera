package pe.edu.utp.gestion_cochera;

import org.junit.jupiter.api.Test;
import pe.edu.utp.gestion_cochera.service.patron.singleton.GeneradorCodigoPago;

public class SingletonTest {
    @Test
    void singletonTest() {
        String codigo = GeneradorCodigoPago.getInstance().generarCodigoDePago(320L);
        System.out.println(codigo);
    }
}
