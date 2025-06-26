package pe.edu.upc.logisticmaster.backendandroid.backend.task.interfaces.rest.transform;

import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model.Task;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.transform.WorkerDto;

import java.util.List;
import java.util.stream.Collectors;

public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private String createdAt;
    private String updatedAt;
    private List<WorkerDto> workers;

    public TaskDto(Task task) {
        this.id          = task.getId();
        this.title       = task.getTitle();
        this.description = task.getDescription();
        this.createdAt   = task.getCreatedAt();
        this.updatedAt   = task.getUpdatedAt();
        this.workers     = task.getWorkers().stream()
                .map(WorkerDto::new)
                .collect(Collectors.toList());
    }

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public List<WorkerDto> getWorkers() {
        return workers;
    }
}
