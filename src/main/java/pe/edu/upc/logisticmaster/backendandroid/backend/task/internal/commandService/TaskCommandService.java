package pe.edu.upc.logisticmaster.backendandroid.backend.task.internal.commandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model.TaskAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.repositories.TaskRepository;


@Service
public class TaskCommandService {

    private final TaskRepository repo;

    public TaskCommandService(TaskRepository repo) {
        this.repo = repo;
    }

    public TaskAggregate create(TaskAggregate t) {
        return repo.save(t);
    }

    public TaskAggregate update(Long id, TaskAggregate t) {
        t.setId(id);
        return repo.save(t);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}