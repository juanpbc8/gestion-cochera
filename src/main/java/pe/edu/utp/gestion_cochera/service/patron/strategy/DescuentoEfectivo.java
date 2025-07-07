package pe.edu.utp.gestion_cochera.service.patron.strategy;

import java.math.BigDecimal;

public class DescuentoEfectivo implements DescuentoEstrategia {
    @Override
    public BigDecimal aplicarDescuento(BigDecimal montoOriginal) {
        // 10% de descuento por pagar con efectivo
        return montoOriginal.multiply(BigDecimal.valueOf(0.9));
    }
}
