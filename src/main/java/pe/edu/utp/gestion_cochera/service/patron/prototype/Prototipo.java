package pe.edu.utp.gestion_cochera.service.patron.prototype;

/**
 * Interfaz que define el contrato del patrón de diseño Prototype.
 * Permite clonar objetos sin acoplarse a sus clases concretas.
 *
 * @param <T> Tipo del objeto que se va a clonar.
 * @author Joel
 * @version 1.0
 */
public interface Prototipo<T> {
    T clonar();
}
