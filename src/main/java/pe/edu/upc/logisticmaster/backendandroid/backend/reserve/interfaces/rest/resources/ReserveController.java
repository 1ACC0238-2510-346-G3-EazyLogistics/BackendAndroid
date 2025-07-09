package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.interfaces.rest.resources;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.internal.commandService.ReserveCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.internal.QueryService.ReserveQueryService;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.interfaces.rest.resources.ReserveDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveAggregate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reserves")
public class ReserveController {

    private final ReserveCommandService command;
    private final ReserveQueryService query;

    public ReserveController(ReserveCommandService command, ReserveQueryService query) {
        this.command = command;
        this.query = query;
    }

    private ReserveDto toDto(ReserveAggregate r) {
        return new ReserveDto(
                r.getId(),
                r.getNombreHuespedes(),
                r.getHabitacion(),
                r.getHoraIngreso(),
                r.getHoraSalida(),
                r.getFechaCreacion()
        );
    }

    private ReserveAggregate toEntity(ReserveDto dto) {
        // NO usamos dto.getFechaCreacion(): lo genera la BD
        return new ReserveAggregate(
                dto.getId(),
                dto.getNombreHuespedes(),
                dto.getHabitacion(),
                dto.getHoraIngreso(),
                dto.getHoraSalida()
        );
    }

    @GetMapping
    public List<ReserveDto> list() {
        return query.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReserveDto get(@PathVariable Long id) {
        return toDto(query.findById(id));
    }

    @PostMapping
    public ReserveDto create(@RequestBody ReserveDto dto) {
        // Ignoramos cualquier dto.id o dto.fechaCreacion que venga
        dto.setId(null);
        ReserveAggregate saved = command.create(toEntity(dto));
        return toDto(saved);
    }

    @PutMapping("/{id}")
    public ReserveDto update(@PathVariable Long id, @RequestBody ReserveDto dto) {
        // NO permitimos cambiar fechaCreacion
        ReserveAggregate updated = command.update(id, toEntity(dto));
        return toDto(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        command.delete(id);
    }
}
