package pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    /**
     * POST /workers
     * – 201 Created si se crea correctamente
     * – 400 Bad Request si faltan campos obligatorios
     * – 500 Internal Server Error en errores inesperados
     */
    @PostMapping
    public ResponseEntity<?> createWorker(@RequestBody WorkerCommand cmd) {
        if (cmd.getName() == null || cmd.getName().isBlank()
                || cmd.getPosition() == null || cmd.getPosition().isBlank()
                || cmd.getEmail() == null || cmd.getEmail().isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("Faltan campos obligatorios: name, position, email");
        }
        try {
            WorkerAggregate created = workerService.createWorker(cmd);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(created);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al crear el trabajador");
        }
    }

    /**
     * GET /workers/{id}
     * – 200 OK con el WorkerAggregate
     * – 404 Not Found si no existe
     * – 500 Internal Server Error en errores inesperados
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getWorkerById(@PathVariable Long id) {
        try {
            WorkerAggregate worker = workerService.getWorkerById(id);
            if (worker == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Trabajador con ID " + id + " no encontrado");
            }
            return ResponseEntity.ok(worker);
        } catch (RuntimeException notFound) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(notFound.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al obtener el trabajador");
        }
    }

    /**
     * GET /workers
     * – 200 OK con lista de WorkerAggregate
     * – 500 Internal Server Error en errores inesperados
     */
    @GetMapping
    public ResponseEntity<?> getAllWorkers() {
        try {
            List<WorkerAggregate> list = workerService.getAllWorkers();
            return ResponseEntity.ok(list);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al listar trabajadores");
        }
    }

    /**
     * PUT /workers/{id}
     * – 200 OK si se actualiza correctamente
     * – 400 Bad Request si faltan campos obligatorios
     * – 404 Not Found si no existe
     * – 500 Internal Server Error en errores inesperados
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateWorker(
            @PathVariable Long id,
            @RequestBody WorkerCommand cmd
    ) {
        if (cmd.getName() == null || cmd.getName().isBlank()
                || cmd.getPosition() == null || cmd.getPosition().isBlank()
                || cmd.getEmail() == null || cmd.getEmail().isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("Faltan campos obligatorios: name, position, email");
        }
        try {
            WorkerAggregate updated = workerService.updateWorker(id, cmd);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException notFound) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(notFound.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al actualizar el trabajador");
        }
    }

    /**
     * DELETE /workers/{id}
     * – 200 OK si se elimina correctamente
     * – 404 Not Found si no existe
     * – 500 Internal Server Error en errores inesperados
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWorker(@PathVariable Long id) {
        try {
            workerService.deleteWorker(id);
            return ResponseEntity.ok("Trabajador eliminado correctamente");
        } catch (RuntimeException notFound) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(notFound.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al eliminar el trabajador");
        }
    }
}
