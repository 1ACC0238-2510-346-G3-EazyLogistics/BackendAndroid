package pe.edu.upc.logisticmaster.backendandroid.backend.task.interfaces.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.logisticmaster.backendandroid.backend.task.internal.QueryService.TaskQueryService;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.interfaces.rest.transform.TaskDto;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskQueryService taskQueryService;

    /**
     * GET /tasks/{id}
     * – 200 OK con TaskDto (incluye lista de WorkerDto)
     * – 404 Not Found si no existe la tarea
     * – 500 Internal Server Error en errores inesperados
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        try {
            TaskDto dto = taskQueryService.getTaskById(id);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException notFound) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(notFound.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al obtener la tarea");
        }
    }

    /**
     * GET /tasks
     * – 200 OK con lista de TaskDto
     * – 500 Internal Server Error en errores inesperados
     */
    @GetMapping
    public ResponseEntity<?> getAllTasks() {
        try {
            List<TaskDto> all = taskQueryService.getAllTasks();
            return ResponseEntity.ok(all);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al listar tareas");
        }
    }

    /**
     * DELETE /tasks/{id}
     * – 200 OK si se elimina correctamente
     * – 404 Not Found si no existe la tarea
     * – 500 Internal Server Error en errores inesperados
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        try {
            taskQueryService.deleteTask(id);
            return ResponseEntity.ok("Tarea eliminada correctamente");
        } catch (RuntimeException notFound) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(notFound.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al eliminar la tarea");
        }
    }
}
