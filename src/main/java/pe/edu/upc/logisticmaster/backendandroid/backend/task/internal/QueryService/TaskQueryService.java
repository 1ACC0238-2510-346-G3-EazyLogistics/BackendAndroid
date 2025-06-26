package pe.edu.upc.logisticmaster.backendandroid.backend.task.internal.QueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.services.TaskService;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.interfaces.rest.transform.TaskDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskQueryService {

    @Autowired
    private TaskService taskService;

    public TaskDto getTaskById(Long id) {
        var task = taskService.getTaskById(id);
        if (task == null) {
            throw new RuntimeException("Tarea no encontrada con ID " + id);
        }
        return new TaskDto(task);
    }

    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks()
                .stream()
                .map(TaskDto::new)
                .collect(Collectors.toList());
    }

    public void deleteTask(Long id) {
        taskService.deleteTask(id);
    }
}
