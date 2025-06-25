package pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model;

public class WorkerCommand {
    private String name;
    private String position;
    private String email;
    private boolean isActive;

    // Constructor
    public WorkerCommand(String name, String position, String email, boolean isActive) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.isActive = isActive;
    }

    // Getters y Setters
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
