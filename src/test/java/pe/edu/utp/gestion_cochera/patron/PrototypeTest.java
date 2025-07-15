package pe.edu.utp.gestion_cochera.patron;

import org.junit.jupiter.api.Test;
import pe.edu.utp.gestion_cochera.model.TipoVehiculo;
import pe.edu.utp.gestion_cochera.model.Vehiculo;
import pe.edu.utp.gestion_cochera.service.patron.prototype.VehiculoPrototipo;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para validar el funcionamiento del patrón Prototype.
 * Se verifica que un objeto Vehículo pueda ser clonado correctamente a partir de un prototipo,
 * asegurando que el clon tenga los mismos atributos que el original pero como una instancia independiente.
 *
 * @author Joel
 * @version 1.0
 */
public class PrototypeTest {
    @Test
    void prototipo() {
        // Crear objeto TipoVehiculo
        TipoVehiculo tipoVehiculo = new TipoVehiculo();
        tipoVehiculo.setNombre("Sedán");

        Vehiculo vehiculoOriginal = new Vehiculo();
        vehiculoOriginal.setPlaca("BE1L-562");
        vehiculoOriginal.setMarca("Kia");
        vehiculoOriginal.setModelo("Sportage");
        vehiculoOriginal.setColor("Plomo");

        // Usar el prototipo para clonar
        VehiculoPrototipo prototipo = new VehiculoPrototipo(vehiculoOriginal);
        Vehiculo clon = prototipo.clonar();

        // Validar que no sea la misma instancia
        assertNotSame(vehiculoOriginal, clon, "El clon no debe ser la misma instancia que el original");

        // Validar que los campos primitivos sean iguales
        assertEquals(vehiculoOriginal.getMarca(), clon.getMarca());
        assertEquals(vehiculoOriginal.getModelo(), clon.getModelo());
        assertEquals(vehiculoOriginal.getColor(), clon.getColor());

        // Cambiar algo en el clon para diferenciarlo y validar que tenga otra placa
        clon.setPlaca("TAI-801");
        clon.setColor("Azul");
        assertNotEquals(vehiculoOriginal.getPlaca(), clon.getPlaca());

        // Mostrar resultados
        System.out.println("Vehículo Original:");
        mostrarVehiculo(vehiculoOriginal);

        System.out.println("\nVehículo Clonado:");
        mostrarVehiculo(clon);
    }

    private static void mostrarVehiculo(Vehiculo v) {
        System.out.println("Placa: " + v.getPlaca());
        System.out.println("Marca: " + v.getMarca());
        System.out.println("Modelo: " + v.getModelo());
        System.out.println("Color: " + v.getColor());
    }
}
