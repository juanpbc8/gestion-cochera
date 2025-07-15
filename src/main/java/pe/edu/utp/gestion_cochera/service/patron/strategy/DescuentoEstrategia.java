package pe.edu.utp.gestion_cochera.service.patron.strategy;

import java.math.BigDecimal;

/**
 * Interfaz que define la estrategia de cálculo de descuento.
 * Forma parte del patrón de diseño Strategy, permitiendo intercambiar
 * dinámicamente diferentes formas de aplicar descuentos sin modificar el contexto.
 *
 * @author Juan
 * @version 1.0
 */
public interface DescuentoEstrategia {
    BigDecimal aplicarDescuento(BigDecimal montoOriginal);
}
