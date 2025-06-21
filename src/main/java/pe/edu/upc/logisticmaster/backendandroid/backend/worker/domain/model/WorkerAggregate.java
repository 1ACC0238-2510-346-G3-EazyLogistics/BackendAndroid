package pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkerAggregate {
    private Long id;
    private String name;
    private String position;
    private String email;
    private boolean isActive;

    public WorkerAggregate(String name, String position, String email, boolean isActive) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.email = email;
        this.isActive = isActive;
    }
}
