package pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model.Task;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Crear o actualizar una tarea
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Obtener todas las tareas
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Obtener tarea por ID
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // Eliminar tarea por ID
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
