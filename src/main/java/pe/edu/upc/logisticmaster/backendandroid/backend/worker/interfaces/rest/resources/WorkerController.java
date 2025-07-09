package pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.resources;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.internal.commandService.WorkerCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.internal.queryService.WorkerQueryService;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.transform.WorkerDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.transform.TaskDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    private final WorkerCommandService command;
    private final WorkerQueryService query;

    public WorkerController(WorkerCommandService command,
                            WorkerQueryService query) {
        this.command = command;
        this.query = query;
    }

    private WorkerDto toDto(WorkerAggregate w) {
        List<TaskDto> ts = w.getTasks().stream()
                .map(t -> new TaskDto(
                        t.getId(),
                        t.getTitulo(),
                        t.getDescripcion(),
                        w.getId()
                ))
                .collect(Collectors.toList());

        return new WorkerDto(
                w.getId(),
                w.getNombre(),
                w.getApellido(),
                w.getEmail(),
                w.getTelefono(),
                w.getPuesto(),
                w.getArea(),
                ts
        );
    }

    private WorkerAggregate toEntity(WorkerDto dto) {
        WorkerAggregate w = new WorkerAggregate(
                dto.getId(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getEmail(),
                dto.getTelefono(),
                dto.getPuesto(),
                dto.getArea()
        );
        // las tasks se gestionan por separado vía TaskController
        return w;
    }

    @GetMapping
    public List<WorkerDto> list() {
        return query.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public WorkerDto get(@PathVariable Long id) {
        return toDto(query.findById(id));
    }

    @PostMapping
    public WorkerDto create(@RequestBody WorkerDto dto) {
        WorkerAggregate saved = command.create(toEntity(dto));
        return toDto(saved);
    }

    @PutMapping("/{id}")
    public WorkerDto update(@PathVariable Long id, @RequestBody WorkerDto dto) {
        WorkerAggregate updated = command.update(id, toEntity(dto));
        return toDto(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        command.delete(id);
    }
}
