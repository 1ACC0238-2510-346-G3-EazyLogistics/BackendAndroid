package pe.edu.upc.logisticmaster.backendandroid.backend.task.transform;

/**
 * DTO usado para serializar/de-serializar JSON de Task
 */
public class TaskDto {
    private Long id;
    private String titulo;
    private String descripcion;
    private Long workerId;

    public TaskDto() { }

    public TaskDto(Long id, String titulo, String descripcion, Long workerId) {
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
}
