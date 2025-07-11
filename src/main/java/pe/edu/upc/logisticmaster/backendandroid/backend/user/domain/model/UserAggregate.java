// src/main/java/pe/edu/upc/logisticmaster/backendandroid/backend/user/domain/model/UserAggregate.java
package pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model;

import jakarta.persistence.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.transform.UserDto;

@Entity
@Table(name = "usuario")
public class UserAggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario", nullable = false, unique = true)
    private String usuario;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "contraseña", nullable = false)
    private String contrasena;

    public UserAggregate() {
    }

    // Constructor con ID (para actualizaciones)
    public UserAggregate(Long id, String usuario, String email, String nombre, String apellido, String contrasena) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
    }

    // Constructor sin ID (para nuevos usuarios)
    public UserAggregate(String usuario, String email, String nombre, String apellido, String contrasena) {
        this.usuario = usuario;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /** Mapea de DTO a Aggregate */
    public static UserAggregate fromDto(UserDto dto) {
        return new UserAggregate(
                dto.getId(),
                dto.getUsuario(),
                dto.getEmail(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getContrasena());
    }

    /** Mapea de DTO a Aggregate para nuevo usuario (sin ID) */
    public static UserAggregate fromDtoForCreation(UserDto dto) {
        return new UserAggregate(
                dto.getUsuario(),
                dto.getEmail(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getContrasena());
    }

    /** Mapea de Aggregate a DTO */
    public UserDto toDto() {
        return new UserDto(
                id, usuario, email, nombre, apellido, contrasena);
    }
}
