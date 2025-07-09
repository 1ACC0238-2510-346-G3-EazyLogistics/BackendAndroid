package pe.edu.upc.logisticmaster.backendandroid.backend.task.internal.QueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model.TaskAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.repositories.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class TaskQueryService {

    private final TaskRepository repo;

    public TaskQueryService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<TaskAggregate> findAll() {
        return repo.findAll();
    }

    public TaskAggregate findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada: " + id));
    }
}