package pe.edu.utp.gestion_cochera.service.patron.strategy;

import java.math.BigDecimal;

/**
 * Estrategia concreta que aplica un 5% de descuento por pago con tarjeta.
 * Implementa la interfaz {@link DescuentoEstrategia} como parte del patrón Strategy.
 *
 * @author Juan
 * @version 1.0
 */
public class DescuentoTarjeta implements DescuentoEstrategia {
    @Override
    public BigDecimal aplicarDescuento(BigDecimal montoOriginal) {
        // 5% de descuento por pagar con tarjeta
        return montoOriginal.multiply(BigDecimal.valueOf(0.95));
    }
}
