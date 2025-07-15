package pe.edu.utp.gestion_cochera.service.patron.strategy;

import java.math.BigDecimal;

/**
 * Estrategia concreta que aplica un 10% de descuento por pago en efectivo.
 * Implementa la interfaz {@link DescuentoEstrategia} como parte del patrón Strategy.
 *
 * @author Juan
 * @version 1.0
 */
public class DescuentoEfectivo implements DescuentoEstrategia {
    @Override
    public BigDecimal aplicarDescuento(BigDecimal montoOriginal) {
        // 10% de descuento por pagar con efectivo
        return montoOriginal.multiply(BigDecimal.valueOf(0.9));
    }
}
