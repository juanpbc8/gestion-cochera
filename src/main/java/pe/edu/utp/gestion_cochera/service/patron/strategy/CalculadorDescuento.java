package pe.edu.utp.gestion_cochera.service.patron.strategy;

import java.math.BigDecimal;

/**
 * Contexto del patrón de diseño Strategy para el cálculo de descuentos.
 * Permite asignar dinámicamente una estrategia concreta de descuento y aplicarla
 * sobre un monto determinado, promoviendo flexibilidad y separación de responsabilidades.
 *
 * @author Juan
 * @version 1.0
 */
public class CalculadorDescuento {

    private DescuentoEstrategia estrategia;

    public void setEstrategia(DescuentoEstrategia estrategia) {
        this.estrategia = estrategia;
    }

    public BigDecimal calcular(BigDecimal montoOriginal) {
        return estrategia.aplicarDescuento(montoOriginal);
    }
}
