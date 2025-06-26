package pe.edu.upc.logisticmaster.backendandroid.backend.task.internal.QueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model.Task;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.services.TaskService;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.interfaces.rest.transform.TaskDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskQueryService {

    @Autowired
    private TaskService taskService;

    // Obtener todas las tareas
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return tasks.stream().map(TaskDto::new).collect(Collectors.toList());
    }

    // Obtener tarea por ID
    public TaskDto getTaskById(Long id) {
        Task task = taskService.getTaskById(id);
        return new TaskDto(task);
    }

    // Eliminar tarea por ID
    public void deleteTask(Long id) {
        taskService.deleteTask(id);
    }
}
