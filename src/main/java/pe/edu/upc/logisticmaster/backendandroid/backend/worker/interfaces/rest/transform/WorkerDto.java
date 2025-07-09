package pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.transform;

import java.util.List;
import pe.edu.upc.logisticmaster.backendandroid.backend.task.transform.TaskDto;

public class WorkerDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String puesto;
    private String area;
    private List<TaskDto> tasks;

    public WorkerDto() { }

    public WorkerDto(Long id,
                     String nombre,
                     String apellido,
                     String email,
                     String telefono,
                     String puesto,
                     String area,
                     List<TaskDto> tasks) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.puesto = puesto;
        this.area = area;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public List<TaskDto> getTasks() {
        return tasks;
    }
    public void setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
    }
}
