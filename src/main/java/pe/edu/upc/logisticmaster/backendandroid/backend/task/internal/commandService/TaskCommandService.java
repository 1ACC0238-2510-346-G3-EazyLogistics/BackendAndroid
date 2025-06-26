package pe.edu.upc.logisticmaster.backendandroid.backend.task.internal.commandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model.Task;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.services.TaskService;

@Service
public class TaskCommandService {

    @Autowired
    private TaskService taskService;

    // Crear o actualizar una tarea
    public void executeCreateTask(Task task) {
        taskService.createTask(task);
    }

    // Eliminar tarea por ID
    public void executeDeleteTask(Long id) {
        taskService.deleteTask(id);
    }
}
