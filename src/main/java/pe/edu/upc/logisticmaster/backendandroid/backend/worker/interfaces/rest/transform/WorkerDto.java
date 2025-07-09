package pe.edu.upc.logisticmaster.backendandroid.backend.worker.interfaces.rest.transform;

/**
 * DTO para serializar/deserializar JSON de Worker
 */
public class WorkerDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String puesto;
    private String area;

    public WorkerDto() { }

    public WorkerDto(
            Long id,
            String nombre,
            String apellido,
            String email,
            String telefono,
            String puesto,
            String area
    ) {
        this.id       = id;
        this.nombre   = nombre;
        this.apellido = apellido;
        this.email    = email;
        this.telefono = telefono;
        this.puesto   = puesto;
        this.area     = area;
    }

    public Long getId()             { return id; }
    public String getNombre()       { return nombre; }
    public String getApellido()     { return apellido; }
    public String getEmail()        { return email; }
    public String getTelefono()     { return telefono; }
    public String getPuesto()       { return puesto; }
    public String getArea()         { return area; }

    public void setId(Long id)              { this.id = id; }
    public void setNombre(String nombre)    { this.nombre = nombre; }
    public void setApellido(String apellido){ this.apellido = apellido; }
    public void setEmail(String email)      { this.email = email; }
    public void setTelefono(String telefono){ this.telefono = telefono; }
    public void setPuesto(String puesto)    { this.puesto = puesto; }
    public void setArea(String area)        { this.area = area; }
}
