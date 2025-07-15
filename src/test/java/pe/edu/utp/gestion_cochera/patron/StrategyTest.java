package pe.edu.utp.gestion_cochera.patron;

import org.junit.jupiter.api.Test;
import pe.edu.utp.gestion_cochera.service.patron.strategy.CalculadorDescuento;
import pe.edu.utp.gestion_cochera.service.patron.strategy.DescuentoEfectivo;
import pe.edu.utp.gestion_cochera.service.patron.strategy.DescuentoTarjeta;
import pe.edu.utp.gestion_cochera.service.patron.strategy.DescuentoYape;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Pruebas unitarias para verificar el funcionamiento del patrón Strategy
 * aplicado al cálculo de descuentos según el método de pago.
 * Se valida que cada estrategia (efectivo, tarjeta, Yape) aplique correctamente
 * el descuento sobre el monto original según la lógica definida.
 *
 * @author Juan
 * @version 1.0
 */
public class StrategyTest {
    @Test
    void estrategiaEfectivo() {
        CalculadorDescuento calculador = new CalculadorDescuento();
        BigDecimal montoOriginal = new BigDecimal("850.50");

        calculador.setEstrategia(new DescuentoEfectivo());
        BigDecimal resultado = calculador.calcular(montoOriginal);
        BigDecimal esperado = montoOriginal.multiply(BigDecimal.valueOf(0.9));

        assertEquals(esperado, resultado, "El descuento en efectivo debe ser del 10%");
    }

    @Test
    void estrategiaTarjeta() {
        CalculadorDescuento calculador = new CalculadorDescuento();
        BigDecimal montoOriginal = new BigDecimal("850.50");

        calculador.setEstrategia(new DescuentoTarjeta());
        BigDecimal resultado = calculador.calcular(montoOriginal);
        BigDecimal esperado = montoOriginal.multiply(BigDecimal.valueOf(0.95));

        assertEquals(esperado, resultado, "El descuento con tarjeta debe ser del 5%");
    }

    @Test
    void estrategiaYape() {
        CalculadorDescuento calculador = new CalculadorDescuento();
        BigDecimal montoOriginal = new BigDecimal("850.50");

        calculador.setEstrategia(new DescuentoYape());
        BigDecimal resultado = calculador.calcular(montoOriginal);

        assertEquals(montoOriginal, resultado, "Con Yape no debe aplicarse descuento");
    }
}
