package pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model;

import jakarta.persistence.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model.WorkerAggregate;

@Entity
@Table(name = "task")
public class TaskAggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado_id", nullable = false)
    private WorkerAggregate worker;

    protected TaskAggregate() { }

    /**
     * Constructor que coincide con toEntity(dto).
     * El primer parámetro puede ser null para creación (JPA lo ignorará y generará uno nuevo).
     */
    public TaskAggregate(Long id,
                         String titulo,
                         String descripcion,
                         WorkerAggregate worker) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.worker = worker;
    }

    // --- Getters & setters manuales ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public WorkerAggregate getWorker() {
        return worker;
    }

    public void setWorker(WorkerAggregate worker) {
        this.worker = worker;
    }
}
