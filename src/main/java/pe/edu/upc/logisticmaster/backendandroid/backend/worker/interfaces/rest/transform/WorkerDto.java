package pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.transform;

import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerAggregate;

public class WorkerDto {
    private Long id;
    private String name;
    private String position;
    private String email;
    private boolean isActive;

    // Constructor para mapear WorkerAggregate a WorkerDto
    public WorkerDto(WorkerAggregate worker) {
        this.id = worker.getId();      // Asegúrate de que getId() esté generado por Lombok o manualmente
        this.name = worker.getName();  // Asegúrate de que getName() esté generado por Lombok o manualmente
        this.position = worker.getPosition(); // Asegúrate de que getPosition() esté generado por Lombok o manualmente
        this.email = worker.getEmail();  // Esto funciona si tienes getEmail() en WorkerAggregate
        this.isActive = worker.isActive(); // Asegúrate de que isActive() esté generado por Lombok o manualmente
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
