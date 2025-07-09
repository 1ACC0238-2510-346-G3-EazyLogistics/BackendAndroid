package pe.edu.upc.logisticmaster.backendandroid.backend.task.interfaces.rest.resources;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.internal.commandService.TaskCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.internal.QueryService.TaskQueryService;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.internal.queryService.WorkerQueryService;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.transform.TaskDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model.TaskAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerAggregate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskCommandService command;
    private final TaskQueryService query;
    private final WorkerQueryService workerQuery;

    public TaskController(TaskCommandService command,
                          TaskQueryService query,
                          WorkerQueryService workerQuery) {
        this.command = command;
        this.query = query;
        this.workerQuery = workerQuery;
    }

    private TaskDto toDto(TaskAggregate t) {
        return new TaskDto(
                t.getId(),
                t.getTitulo(),
                t.getDescripcion(),
                t.getWorker().getId()
        );
    }

    private TaskAggregate toEntity(TaskDto dto) {
        WorkerAggregate w = workerQuery.findById(dto.getWorkerId());
        return new TaskAggregate(
                dto.getId(),
                dto.getTitulo(),
                dto.getDescripcion(),
                w
        );
    }


    @GetMapping
    public List<TaskDto> list() {
        return query.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TaskDto get(@PathVariable Long id) {
        return toDto(query.findById(id));
    }

    @PostMapping
    public TaskDto create(@RequestBody TaskDto dto) {
        TaskAggregate saved = command.create(toEntity(dto));
        return toDto(saved);
    }

    @PutMapping("/{id}")
    public TaskDto update(@PathVariable Long id, @RequestBody TaskDto dto) {
        TaskAggregate updated = command.update(id, toEntity(dto));
        return toDto(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        command.delete(id);
    }
}
