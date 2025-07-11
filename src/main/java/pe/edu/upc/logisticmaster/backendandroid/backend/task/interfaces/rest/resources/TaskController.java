package pe.edu.upc.logisticmaster.backendandroid.backend.task.interfaces.rest.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.internal.commandService.TaskCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.internal.QueryService.TaskQueryService;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.transform.TaskDto;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskQueryService  queryService;
    private final TaskCommandService commandService;

    public TaskController(
            TaskQueryService queryService,
            TaskCommandService commandService
    ) {
        this.queryService  = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<TaskDto> getAll() {
        return queryService.getAll();
    }

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id) {
        return queryService.getById(id);
    }

    @GetMapping("/worker/{workerId}")
    public List<TaskDto> getByWorker(@PathVariable Long workerId) {
        return queryService.getByWorkerId(workerId);
    }

    @PostMapping
    public TaskDto create(@RequestBody TaskDto dto) {
        return commandService.create(dto);
    }

    @PutMapping("/{id}")
    public TaskDto update(
            @PathVariable Long id,
            @RequestBody TaskDto dto
    ) {
        return commandService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        commandService.delete(id);
    }
}
