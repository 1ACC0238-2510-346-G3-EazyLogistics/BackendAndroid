package pe.edu.upc.logisticmaster.backendandroid.backend.user.transform;

/**
 * DTO para serializar/deserializar datos de usuario
 */
public class UserDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String email;
    private String contraseña;

    public UserDto() {}

    public UserDto(Long id, String nombre, String apellido,
                   String usuario, String email, String contraseña) {
        this.id         = id;
        this.nombre     = nombre;
        this.apellido   = apellido;
        this.usuario    = usuario;
        this.email      = email;
        this.contraseña = contraseña;
    }

    public Long getId()           { return id; }
    public String getNombre()     { return nombre; }
    public String getApellido()   { return apellido; }
    public String getUsuario()    { return usuario; }
    public String getEmail()      { return email; }
    public String getContraseña() { return contraseña; }

    public void setId(Long id)               { this.id = id; }
    public void setNombre(String nombre)     { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setUsuario(String usuario)   { this.usuario = usuario; }
    public void setEmail(String email)       { this.email = email; }
    public void setContraseña(String c)      { this.contraseña = c; }
}
