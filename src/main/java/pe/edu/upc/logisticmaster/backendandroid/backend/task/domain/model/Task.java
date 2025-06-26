package pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model;

import jakarta.persistence.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model.User;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String createdAt;

    private String updatedAt;

    // Relación con User (asignado a un usuario)
    @ManyToOne
    @JoinColumn(name = "assigned_to", referencedColumnName = "email")
    private User assignedTo;

    // Constructor
    public Task(String title, String description, String createdAt, String updatedAt, User assignedTo) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.assignedTo = assignedTo;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }
}
