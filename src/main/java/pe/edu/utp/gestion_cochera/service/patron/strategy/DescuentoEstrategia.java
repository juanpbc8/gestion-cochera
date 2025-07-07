package pe.edu.utp.gestion_cochera.service.patron.strategy;

import pe.edu.utp.gestion_cochera.model.Vehiculo;

import java.math.BigDecimal;

public interface DescuentoEstrategia {
    BigDecimal aplicarDescuento(BigDecimal montoOriginal);
}
