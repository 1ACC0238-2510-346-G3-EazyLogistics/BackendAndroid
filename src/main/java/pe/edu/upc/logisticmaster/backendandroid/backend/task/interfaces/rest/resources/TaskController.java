package pe.edu.upc.logisticmaster.backendandroid.backend.task.interfaces.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model.Task;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.services.TaskService;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.internal.QueryService.TaskQueryService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskQueryService taskQueryService;

    /**
     * Crear una nueva tarea
     * - 201 Created con la tarea creada
     * - 400 Bad Request si faltan campos obligatorios
     * - 500 Internal Server Error en errores inesperados
     */
    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        // Validación de campos obligatorios
        if (task.getTitle() == null || task.getTitle().isBlank()
                || task.getDescription() == null || task.getDescription().isBlank()
                || task.getCreatedAt() == null || task.getCreatedAt().isBlank()
                || task.getUpdatedAt() == null || task.getUpdatedAt().isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("Faltan campos obligatorios: title, description, createdAt, updatedAt");
        }

        try {
            Task created = taskService.createTask(task);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(created);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al crear la tarea");
        }
    }

    /**
     * Listar todas las tareas
     * - 200 OK con la lista de tareas
     * - 500 Internal Server Error en errores inesperados
     */
    @GetMapping
    public ResponseEntity<?> getAllTasks() {
        try {
            List<Task> tasks = taskService.getAllTasks();
            return ResponseEntity.ok(tasks);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al listar las tareas");
        }
    }

    /**
     * Obtener tarea por ID
     * - 200 OK con la tarea
     * - 404 Not Found si no existe
     * - 500 Internal Server Error en errores inesperados
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        try {
            Task task = taskService.getTaskById(id);
            if (task == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Tarea con ID " + id + " no encontrada");
            }
            return ResponseEntity.ok(task);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al obtener la tarea");
        }
    }

    /**
     * Eliminar tarea por ID
     * - 200 OK si se elimina correctamente
     * - 404 Not Found si no existe la tarea
     * - 500 Internal Server Error en errores inesperados
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        try {
            // Verificar existencia
            Task existing = taskService.getTaskById(id);
            if (existing == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Tarea con ID " + id + " no encontrada");
            }
            taskQueryService.deleteTask(id);
            return ResponseEntity.ok("Tarea eliminada correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al eliminar la tarea");
        }
    }
}
