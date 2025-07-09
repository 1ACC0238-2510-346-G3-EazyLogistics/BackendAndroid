package pe.edu.upc.logisticmaster.backendandroid.backend.task.internal.commandService;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model.TaskAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.repositories.TaskRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.transform.TaskDto;

@Service
public class TaskCommandService {

    private final TaskRepository repository;

    public TaskCommandService(TaskRepository repository) {
        this.repository = repository;
    }

    /** Crea una nueva tarea */
    public TaskDto create(TaskDto dto) {
        TaskAggregate agg = new TaskAggregate(
                null,
                dto.getTitulo(),
                dto.getDescripcion(),
                dto.getWorkerId()
        );
        TaskAggregate saved = repository.save(agg);
        return saved.toDto();
    }

    /** Actualiza una tarea existente */
    public TaskDto update(Long id, TaskDto dto) {
        TaskAggregate existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada: " + id));

        existing.setTitulo(dto.getTitulo());
        existing.setDescripcion(dto.getDescripcion());
        existing.setWorkerId(dto.getWorkerId());

        TaskAggregate updated = repository.save(existing);
        return updated.toDto();
    }

    /** Elimina una tarea por su ID */
    public void delete(Long id) {
        repository.deleteById(id);
    }

    /** (Opcional) elimina varias tareas */
    public void deleteAllByWorker(Long workerId) {
        List<TaskAggregate> list = repository.findByWorkerId(workerId);
        repository.deleteAll(list);
    }
}
