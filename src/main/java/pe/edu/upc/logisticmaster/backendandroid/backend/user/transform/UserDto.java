// src/main/java/pe/edu/upc/logisticmaster/backendandroid/backend/user/transform/UserDto.java
package pe.edu.upc.logisticmaster.backendandroid.backend.user.transform;

public class UserDto {
    private Long id;
    private String usuario;
    private String email;
    private String nombre;
    private String apellido;
    private String contrasena;

    public UserDto() {}

    public UserDto(Long id, String usuario, String email, String nombre, String apellido, String contrasena) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}
