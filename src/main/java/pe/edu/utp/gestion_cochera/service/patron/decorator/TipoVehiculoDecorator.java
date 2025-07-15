package pe.edu.utp.gestion_cochera.service.patron.decorator;

/**
 * Decorador abstracto que permite extender funcionalidad de un tipo de vehículo.
 *
 * @author Stephano
 * @version 1.0
 */
public abstract class TipoVehiculoDecorator implements TipoVehiculoComponent {
    protected TipoVehiculoComponent componente;

    public TipoVehiculoDecorator(TipoVehiculoComponent componente) {
        this.componente = componente;
    }

    @Override
    public String obtenerDescripcion() {
        return componente.obtenerDescripcion();
    }
}