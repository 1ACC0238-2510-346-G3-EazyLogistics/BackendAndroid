package pe.edu.upc.logisticmaster.backendandroid.backend.task.interfaces.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
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

    // Crear o actualizar una tarea
    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return ResponseEntity.ok("Task created successfully");
    }

    // Obtener todas las tareas
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    // Obtener tarea por ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    // Eliminar tarea por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        // Llamar al servicio para eliminar la tarea
        taskQueryService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
