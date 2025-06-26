// src/main/java/pe/edu/upc/logisticmaster/backendandroid/backend/worker/domain/model/WorkerAggregate.java
package pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model.Task;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthAggregate;

@Entity
@Table(name = "worker_aggregate")
public class WorkerAggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Clave natural para enlazar con AuthAggregate
    @Column(unique = true, nullable = false)
    private String email;

    private String name;
    private String position;
    private boolean isActive;

    // FK worker_aggregate.email → auth_aggregate.email
    @OneToOne
    @JoinColumn(
            name = "email",
            referencedColumnName = "email",
            insertable = false,
            updatable = false
    )
    private AuthAggregate authAggregate;

    @ManyToMany
    @JoinTable(
            name = "worker_task",
            joinColumns = @JoinColumn(name = "worker_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private Set<Task> tasks = new HashSet<>();

    public WorkerAggregate() {}

    public WorkerAggregate(String email, String name, String position, boolean isActive) {
        this.email    = email;
        this.name     = name;
        this.position = position;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
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

    public AuthAggregate getAuthAggregate() {
        return authAggregate;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
