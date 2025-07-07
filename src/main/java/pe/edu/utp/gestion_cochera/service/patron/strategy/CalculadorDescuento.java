package pe.edu.utp.gestion_cochera.service.patron.strategy;

import java.math.BigDecimal;

public class CalculadorDescuento {

    private DescuentoEstrategia estrategia;

    public void setEstrategia(DescuentoEstrategia estrategia) {
        this.estrategia = estrategia;
    }

    public BigDecimal calcular(BigDecimal montoOriginal) {
        return estrategia.aplicarDescuento(montoOriginal);
    }
}
