package pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor  // Constructor con todos los parámetros
@Getter  // Genera el getter
@Setter  // Genera el setter
public class WorkerCommand {
    private String name;
    private String position;
    private String email;
    private boolean isActive;
}
