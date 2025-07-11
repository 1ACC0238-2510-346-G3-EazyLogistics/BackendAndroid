// src/main/java/pe/edu/upc/logisticmaster/backendandroid/backend/user/interfaces/rest/resources/UserController.java
package pe.edu.upc.logisticmaster.backendandroid.backend.user.interfaces.rest.resources;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.services.UserService;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.transform.UserDto;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService svc;

    public UserController(UserService svc) {
        this.svc = svc;
    }

    /** CREATE */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserDto dto) {
        try {
            // Asegurar que el ID sea null para nuevos usuarios
            dto.setId(null);
            return svc.create(dto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear usuario: " + e.getMessage());
        }
    }

    /** READ ALL */
    @GetMapping
    public List<UserDto> listAll() {
        try {
            return svc.listAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener usuarios: " + e.getMessage());
        }
    }

    /** READ BY ID */
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        try {
            if (id == null || id <= 0) {
                throw new RuntimeException("ID de usuario inválido: " + id);
            }
            return svc.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        }
    }

    /** READ BY USERNAME */
    @GetMapping("/username/{usuario}")
    public UserDto getByUsuario(@PathVariable String usuario) {
        try {
            if (usuario == null || usuario.trim().isEmpty()) {
                throw new RuntimeException("Username no puede estar vacío");
            }
            return svc.getByUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Usuario no encontrado con username: " + usuario);
        }
    }

    /** READ BY EMAIL */
    @GetMapping("/email/{email}")
    public UserDto getByEmail(@PathVariable String email) {
        try {
            if (email == null || email.trim().isEmpty()) {
                throw new RuntimeException("Email no puede estar vacío");
            }
            return svc.getByEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Usuario no encontrado con email: " + email);
        }
    }

    /** UPDATE BY ID */
    @PutMapping("/{id}")
    public UserDto updateById(@PathVariable Long id, @RequestBody UserDto dto) {
        try {
            if (id == null || id <= 0) {
                throw new RuntimeException("ID de usuario inválido: " + id);
            }
            if (dto == null) {
                throw new RuntimeException("Datos de usuario no pueden estar vacíos");
            }
            dto.setId(id);
            return svc.updateById(dto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar usuario con id: " + id + " - " + e.getMessage());
        }
    }

    /** UPDATE BY EMAIL */
    @PutMapping("/email/{email}")
    public UserDto updateByEmail(@PathVariable String email, @RequestBody UserDto dto) {
        try {
            if (email == null || email.trim().isEmpty()) {
                throw new RuntimeException("Email no puede estar vacío");
            }
            if (dto == null) {
                throw new RuntimeException("Datos de usuario no pueden estar vacíos");
            }
            dto.setEmail(email);
            return svc.updateByEmail(dto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar usuario con email: " + email + " - " + e.getMessage());
        }
    }

    /** DELETE BY ID */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        try {
            if (id == null || id <= 0) {
                throw new RuntimeException("ID de usuario inválido: " + id);
            }
            svc.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar usuario con id: " + id + " - " + e.getMessage());
        }
    }
}
