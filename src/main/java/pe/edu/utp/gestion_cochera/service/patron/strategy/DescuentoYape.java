package pe.edu.utp.gestion_cochera.service.patron.strategy;

import java.math.BigDecimal;

public class DescuentoYape implements DescuentoEstrategia {
    @Override
    public BigDecimal aplicarDescuento(BigDecimal montoOriginal) {
        // Sin descuento por pagar con yape
        return montoOriginal;
    }
}
