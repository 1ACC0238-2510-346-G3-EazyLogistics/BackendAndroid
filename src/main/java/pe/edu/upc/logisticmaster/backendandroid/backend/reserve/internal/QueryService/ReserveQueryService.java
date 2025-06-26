package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.internal.QueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveService;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.interfaces.rest.transform.ReserveDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReserveQueryService {

    @Autowired
    private ReserveService reserveService;

    /**
     * Obtiene una reserva por ID y la mapea a DTO,
     * incluyendo los datos del usuario asociado.
     * @throws RuntimeException si la reserva no existe.
     */
    public ReserveDto getReserveById(Integer id) {
        ReserveAggregate reserve = reserveService.getReserveById(id);  // arroja RuntimeException si no la encuentra
        return new ReserveDto(reserve);
    }

    /**
     * Lista todas las reservas como DTO,
     * cada uno con su usuario embebido.
     */
    public List<ReserveDto> getAllReserves() {
        return reserveService.getAllReserves()
                .stream()
                .map(ReserveDto::new)
                .collect(Collectors.toList());
    }
}
