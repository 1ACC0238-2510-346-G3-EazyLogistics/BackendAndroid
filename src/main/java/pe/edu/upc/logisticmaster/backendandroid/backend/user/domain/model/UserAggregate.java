package pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.transform.UserDto;

@Entity
@Table(name = "usuario")
public class UserAggregate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String email;
    private String contraseña;

    public UserAggregate() {}

    public UserAggregate(Long id, String nombre, String apellido,
                         String usuario, String email, String contraseña) {
        this.id         = id;
        this.nombre     = nombre;
        this.apellido   = apellido;
        this.usuario    = usuario;
        this.email      = email;
        this.contraseña = contraseña;
    }

    // Getters & Setters omitted for brevity…

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

    /** Convierte este aggregate a su DTO JSON */
    public UserDto toDto() {
        return new UserDto(
                this.id,
                this.nombre,
                this.apellido,
                this.usuario,
                this.email,
                this.contraseña
        );
    }
}
