package pe.edu.utp.gestion_cochera.service.patron.strategy;

import java.math.BigDecimal;

public class DescuentoTarjeta implements DescuentoEstrategia {
    @Override
    public BigDecimal aplicarDescuento(BigDecimal montoOriginal) {
        // 5% de descuento por pagar con tarjeta
        return montoOriginal.multiply(BigDecimal.valueOf(0.95));
    }
}
