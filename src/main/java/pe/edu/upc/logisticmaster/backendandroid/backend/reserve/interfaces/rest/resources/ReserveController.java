package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.interfaces.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveService;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.interfaces.rest.transform.ReserveDto;

@RestController
@RequestMapping("/api/reserves")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @PostMapping("/")
    public void createReserve(@RequestBody ReserveCommand command) {
        reserveService.createReserve(command);
    }

    @GetMapping("/{id}")
    public ReserveDto getReserveById(@PathVariable Integer id) {
        // Lógica para transformar el modelo a un DTO
        return new ReserveDto(reserveService.getReserveById(id));
    }
}
