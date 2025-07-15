package pe.edu.utp.gestion_cochera.service.patron.strategy;

import java.math.BigDecimal;

/**
 * Estrategia concreta que no aplica descuento por pago con Yape.
 * Implementa la interfaz {@link DescuentoEstrategia} siguiendo el patrón Strategy.
 *
 * @author Juan
 * @version 1.0
 */
public class DescuentoYape implements DescuentoEstrategia {
    @Override
    public BigDecimal aplicarDescuento(BigDecimal montoOriginal) {
        // Sin descuento por pagar con yape
        return montoOriginal;
    }
}
