package pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerService;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    // Crear un nuevo trabajador
    @PostMapping
    public ResponseEntity<?> createWorker(@RequestBody WorkerCommand workerCommand) {
        // Aquí llamamos al servicio para crear el trabajador
        workerService.createWorker(workerCommand);
        return ResponseEntity.ok("Worker created successfully");
    }

    // Obtener trabajador por ID
    @GetMapping("/{id}")
    public ResponseEntity<WorkerAggregate> getWorkerById(@PathVariable Long id) {
        WorkerAggregate workerDto = workerService.getWorkerById(id);
        return ResponseEntity.ok(workerDto);
    }

    // Obtener todos los trabajadores
    @GetMapping
    public ResponseEntity<List<WorkerAggregate>> getAllWorkers() {
        List<WorkerAggregate> workers = workerService.getAllWorkers();
        return ResponseEntity.ok(workers);
    }

    // Actualizar un trabajador
    @PutMapping("/{id}")
    public ResponseEntity<?> updateWorker(@PathVariable Long id, @RequestBody WorkerCommand workerCommand) {
        workerService.updateWorker(id, workerCommand);
        return ResponseEntity.ok("Worker updated successfully");
    }

    // Eliminar un trabajador
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
        return ResponseEntity.ok("Worker deleted successfully");
    }
}
