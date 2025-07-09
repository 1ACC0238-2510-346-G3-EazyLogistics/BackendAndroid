package pe.edu.upc.logisticmaster.backendandroid.backend.worker.domain.model;

import jakarta.persistence.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.domain.model.TaskAggregate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "worker")
public class WorkerAggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String puesto;
    private String area;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskAggregate> tasks = new ArrayList<>();

    protected WorkerAggregate() { }

    public WorkerAggregate(Long id, String nombre, String apellido, String email,
                           String telefono, String puesto, String area) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.puesto = puesto;
        this.area = area;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public List<TaskAggregate> getTasks() { return tasks; }
    public void setTasks(List<TaskAggregate> tasks) { this.tasks = tasks; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
}
