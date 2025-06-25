package pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.transform;

import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerAggregate;

public class WorkerDto {
    private Long id;
    private String name;
    private String email;
    private String position;
    private boolean isActive;

    // Constructor a partir de WorkerAggregate
    public WorkerDto(WorkerAggregate worker) {
        this.id = worker.getId();
        this.name = worker.getName();
        this.email = worker.getEmail();
        this.position = worker.getPosition();
        this.isActive = worker.isActive();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
