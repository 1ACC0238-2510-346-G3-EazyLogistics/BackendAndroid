package pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model;

import jakarta.persistence.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model.Task;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "worker_aggregate")
public class WorkerAggregate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;
    private String name;
    private String position;
    private boolean isActive;

    @ManyToMany(mappedBy = "workers")
    private Set<Task> tasks = new HashSet<>();

    public WorkerAggregate() {}

    public WorkerAggregate(String email, String name, String position, boolean isActive) {
        this.email = email;
        this.name = name;
        this.position = position;
        this.isActive = isActive;
    }

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
