package pe.edu.utp.gestion_cochera.service.patron.decorator;

import pe.edu.utp.gestion_cochera.model.TipoVehiculo;

/**
 * Decorador concreto que añade una descripción extendida al tipo de vehículo.
 *
 * @author Stephano
 * @version 1.0
 */
public class TipoVehiculoConDescripcion extends TipoVehiculoDecorator {

    private final TipoVehiculo tipoVehiculo;

    public TipoVehiculoConDescripcion(TipoVehiculo tipoVehiculo) {
        super(null); // No se requiere encadenar otro decorador
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public String obtenerDescripcion() {
        return tipoVehiculo.getNombre() + " – Tarifa: S/" + tipoVehiculo.getTarifaHora();
    }
}
