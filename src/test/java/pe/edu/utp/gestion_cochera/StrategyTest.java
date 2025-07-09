package pe.edu.utp.gestion_cochera;

import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.gestion_cochera.service.patron.strategy.CalculadorDescuento;
import pe.edu.utp.gestion_cochera.service.patron.strategy.DescuentoEfectivo;
import pe.edu.utp.gestion_cochera.service.patron.strategy.DescuentoTarjeta;
import pe.edu.utp.gestion_cochera.service.patron.strategy.DescuentoYape;

import java.math.BigDecimal;

public class StrategyTest {
    @Test
    void estrategiaEfectivo() {
        CalculadorDescuento calculadorDescuento = new CalculadorDescuento();
        BigDecimal monto = new BigDecimal(850.50);
        // Descuento Efectivo
        calculadorDescuento.setEstrategia(new DescuentoEfectivo());
        System.out.println("Descuento efectivo: \n" + calculadorDescuento.calcular(monto));

        // Descuento Tarjeta
        calculadorDescuento.setEstrategia(new DescuentoTarjeta());
        System.out.println("Descuento tarjeta: \n" + calculadorDescuento.calcular(monto));

        // Descuento Yape
        calculadorDescuento.setEstrategia(new DescuentoYape());
        System.out.println("Descuento yapeo: \n" + calculadorDescuento.calcular(monto));
    }
}
