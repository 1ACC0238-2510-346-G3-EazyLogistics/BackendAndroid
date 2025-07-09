package pe.edu.upc.logisticmaster.backendandroid.backend.user.transform;

public class UserDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String email;
    private String contraseña;

    public UserDto() { }

    public UserDto(Long id,
                   String nombre,
                   String apellido,
                   String usuario,
                   String email,
                   String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.email = email;
        this.contraseña = contraseña;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
}
