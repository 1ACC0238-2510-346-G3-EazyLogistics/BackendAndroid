package pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.resources;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.transform.WorkerDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.internal.commandService.WorkerCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.internal.queryService.WorkerQueryService;

@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    private final WorkerQueryService queryService;
    private final WorkerCommandService commandService;

    public WorkerController(
            WorkerQueryService queryService,
            WorkerCommandService commandService
    ) {
        this.queryService  = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<WorkerDto> getAll() {
        return queryService.getAll();
    }

    @GetMapping("/{id}")
    public WorkerDto getById(@PathVariable Long id) {
        return queryService.getById(id);
    }

    @PostMapping
    public WorkerDto create(@RequestBody WorkerDto dto) {
        return commandService.create(dto);
    }

    @PutMapping("/{id}")
    public WorkerDto update(
            @PathVariable Long id,
            @RequestBody WorkerDto dto
    ) {
        return commandService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        commandService.delete(id);
    }
}
