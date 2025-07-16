package pe.edu.utp.gestion_cochera.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.gestion_cochera.dto.PagoDTO;
import pe.edu.utp.gestion_cochera.enums.EstadoPago;
import pe.edu.utp.gestion_cochera.enums.MetodoPago;
import pe.edu.utp.gestion_cochera.model.Pago;
import pe.edu.utp.gestion_cochera.model.Reserva;
import pe.edu.utp.gestion_cochera.repository.PagoRepository;
import pe.edu.utp.gestion_cochera.service.PagoService;
import pe.edu.utp.gestion_cochera.service.patron.singleton.GeneradorCodigoPago;
import pe.edu.utp.gestion_cochera.service.patron.strategy.CalculadorDescuento;
import pe.edu.utp.gestion_cochera.service.patron.strategy.DescuentoEfectivo;
import pe.edu.utp.gestion_cochera.service.patron.strategy.DescuentoTarjeta;
import pe.edu.utp.gestion_cochera.service.patron.strategy.DescuentoYape;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Implementación del servicio {@link PagoService} que gestiona la lógica de negocio
 * relacionada al procesamiento de pagos.
 * Esta clase controla la conversión desde DTOs hacia entidades, garantiza el manejo
 * de transacciones, y valida la existencia de registros antes de realizar acciones críticas.
 *
 * @author Juan
 * @version 1.0
 */
@Service
public class PagoServiceImpl implements PagoService {
    private final PagoRepository repo;

    public PagoServiceImpl(PagoRepository repo) {
        this.repo = repo;
    }

    /**
     * Guarda un nuevo pago aplicando lógica de negocio adicional:
     * <ul>
     *     <li>Se aplica un descuento dinámico al monto según el método de pago
     *     utilizando el patrón Strategy.</li>
     *     <li>Se genera un código único de pago utilizando el patrón Singleton.</li>
     * </ul>
     *
     * @param dto El DTO con los datos del pago a registrar.
     * @return La entidad Pago guardada con descuento aplicado y código generado.
     */
    @Transactional
    @Override
    public Pago guardar(PagoDTO dto) {
        Pago pago = toEntity(dto);
        // Usando Strategy para el descuento segun el metodo de pago
        CalculadorDescuento calculador = new CalculadorDescuento();

        switch (pago.getMetodo()) {
            case EFECTIVO -> {
                calculador.setEstrategia(new DescuentoEfectivo());
            }
            case TARJETA -> {
                calculador.setEstrategia(new DescuentoTarjeta());
            }
            case YAPE -> {
                calculador.setEstrategia(new DescuentoYape());
            }
            default -> {
                throw new IllegalArgumentException("Método de pago no reconocido");
            }
        }

        BigDecimal montoConDescuento = calculador.calcular(pago.getMonto());
        pago.setMonto(montoConDescuento);

        Pago pagoGuardado = repo.save(pago);

        // Generando el codigo con Singleton segun el Id
        String codigo = GeneradorCodigoPago.getInstance().generarCodigoDePago(pagoGuardado.getId());

        pagoGuardado.setCodigo(codigo);
        return repo.save(pagoGuardado);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pago> listar() {
        return repo.findAll();
    }

    @Transactional
    @Override
    public Pago actualizar(Long id, PagoDTO dto) {
        Pago p = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pago no encontrado con ID: " + id));
        return repo.save(toEntity(p, dto));
    }

    @Transactional
    @Override
    public void eliminarPorId(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("El pago con ID " + id + " no existe.");
        }
        repo.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Pago> buscarPorId(Long id) {
        return repo.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pago> buscarPorEstado(EstadoPago estado) {
        return repo.findByEstado(estado);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pago> buscarPorMetodo(MetodoPago metodo) {
        return repo.findByMetodo(metodo);
    }

    @Transactional(readOnly = true)
    @Override
    public long contarPorEstado(EstadoPago estado) {
        return repo.countByEstado(estado);
    }

    @Transactional(readOnly = true)
    @Override
    public long contarPorMetodo(MetodoPago metodo) {
        return repo.countByMetodo(metodo);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pago> buscarPorEstadoYMetodo(EstadoPago estado, MetodoPago metodo) {
        return repo.findByEstadoAndMetodo(estado, metodo);
    }

    /**
     * Convierte un {@link PagoDTO} a una nueva entidad {@link Pago} para su persistencia.
     *
     * @param dto El DTO con los datos del pago.
     * @return La entidad Pago correspondiente.
     */
    private Pago toEntity(PagoDTO dto) {
        Pago p = new Pago();

        Reserva reserva = new Reserva();
        reserva.setId(dto.reservaId());

        p.setReserva(reserva);
        p.setMonto(dto.monto());
        p.setMetodo(dto.metodo());
        p.setFechaPago(dto.fechaPago());
        p.setEstado(dto.estado());
        return p;
    }

    /**
     * Actualiza una entidad existente {@link Pago} a partir de los datos en el {@link PagoDTO}.
     *
     * @param entidad La entidad Pago que se desea actualizar.
     * @param dto     El DTO con los nuevos datos.
     * @return La entidad actualizada.
     */
    private Pago toEntity(Pago entidad, PagoDTO dto) {
        Reserva reserva = new Reserva();
        reserva.setId(dto.reservaId());

        entidad.setReserva(reserva);
        entidad.setMonto(dto.monto());
        entidad.setMetodo(dto.metodo());
        entidad.setFechaPago(dto.fechaPago());
        entidad.setEstado(dto.estado());
        return entidad;
    }
}
