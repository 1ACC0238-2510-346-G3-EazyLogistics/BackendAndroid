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

    // Método para obtener una reserva por ID y devolverla como DTO
    public ReserveDto getReserveById(Integer id) {
        // Llamamos al servicio para obtener la reserva de la base de datos
        ReserveAggregate reserve = reserveService.getReserveById(id);

        // Convertimos la reserva en un DTO para la transferencia de datos
        return new ReserveDto(reserve);
    }

    // Método para obtener todas las reservas
    public List<ReserveDto> getAllReserves() {
        // Obtener todas las reservas desde el servicio
        List<ReserveAggregate> reserves = reserveService.getAllReserves();

        // Convertir las reservas en DTOs
        return reserves.stream()
                .map(ReserveDto::new)
                .collect(Collectors.toList());
    }
}
