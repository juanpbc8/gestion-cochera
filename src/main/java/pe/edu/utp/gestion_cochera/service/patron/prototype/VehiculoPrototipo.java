package pe.edu.utp.gestion_cochera.service.patron.prototype;

import pe.edu.utp.gestion_cochera.model.Vehiculo;

/**
 * Clase que implementa el patrón de diseño Prototype para objetos de tipo Vehiculo.
 * Permite crear nuevas instancias de vehículos copiando sus atributos básicos.
 * Este patrón es útil cuando la creación de un objeto es costosa o compleja,
 * y se requiere duplicar su estado de forma controlada.
 *
 * @author Joel
 * @version 1.0
 */
public class VehiculoPrototipo implements Prototipo<Vehiculo> {

    private Vehiculo vehiculo;

    public VehiculoPrototipo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public Vehiculo clonar() {

        Vehiculo clon = new Vehiculo();

        clon.setColor(vehiculo.getColor());
        clon.setMarca(vehiculo.getMarca());
        clon.setModelo(vehiculo.getModelo());
        clon.setPlaca(vehiculo.getPlaca());
        clon.setPropietario(vehiculo.getPropietario());
        clon.setTipo(vehiculo.getTipo());

        return clon;
    }
}
