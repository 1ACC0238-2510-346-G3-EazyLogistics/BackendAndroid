package pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerService;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.transform.WorkerDto;

@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @PostMapping("/")
    public WorkerDto createWorker(@RequestBody WorkerCommand command) {
        WorkerAggregate worker = workerService.createWorker(command);
        return new WorkerDto(worker);
    }

    @GetMapping("/{id}")
    public WorkerDto getWorkerById(@PathVariable Long id) {
        WorkerAggregate worker = workerService.getWorkerById(id);
        return new WorkerDto(worker);
    }

    @PutMapping("/{id}")
    public WorkerDto updateWorker(@PathVariable Long id, @RequestBody WorkerCommand command) {
        WorkerAggregate worker = workerService.updateWorker(id, command);
        return new WorkerDto(worker);
    }

    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
    }
}
