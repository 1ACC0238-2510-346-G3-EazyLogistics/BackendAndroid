package pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model.TaskAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.repositories.TaskRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.transform.TaskDto;

@Service
public class TaskQueryService {

    private final TaskRepository repo;

    public TaskQueryService(TaskRepository repo) {
        this.repo = repo;
    }

    /** Todas las tareas */
    public List<TaskDto> getAll() {
        return repo.findAll().stream()
                .map(TaskAggregate::toDto)
                .collect(Collectors.toList());
    }

    /** Tarea por ID */
    public TaskDto getById(Long id) {
        return repo.findById(id)
                .map(TaskAggregate::toDto)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada: " + id));
    }

    /** Tareas por Worker ID */
    public List<TaskDto> getByWorkerId(Long workerId) {
        return repo.findByWorkerId(workerId).stream()
                .map(TaskAggregate::toDto)
                .collect(Collectors.toList());
    }
}
