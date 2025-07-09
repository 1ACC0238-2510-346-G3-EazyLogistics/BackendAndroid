package pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.transform.TaskDto;

@Entity
@Table(name = "task")
public class TaskAggregate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private Long workerId;

    public TaskAggregate() { }

    public TaskAggregate(Long id, String titulo, String descripcion, Long workerId) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.workerId = workerId;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public Long getWorkerId() { return workerId; }

    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setWorkerId(Long workerId) { this.workerId = workerId; }

    /**
     * Convierte este aggregate a DTO para transporte JSON
     */
    public TaskDto toDto() {
        return new TaskDto(
                this.id,
                this.titulo,
                this.descripcion,
                this.workerId
        );
    }
}
