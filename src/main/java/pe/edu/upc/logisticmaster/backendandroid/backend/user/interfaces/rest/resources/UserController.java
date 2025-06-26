package pe.edu.upc.logisticmaster.backendandroid.backend.user.interfaces.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model.User;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * POST /users
     * – 201 Created con mensaje
     * – 400 Bad Request si faltan campos obligatorios
     * – 500 Internal Server Error en errores inesperados
     */
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (user == null
                || user.getName() == null || user.getName().isBlank()
                || user.getEmail() == null || user.getEmail().isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("Faltan campos obligatorios: name, email");
        }
        try {
            userService.createUser(user);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("User created successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al crear el usuario");
        }
    }

    /**
     * GET /users/{email}
     * – 200 OK con el usuario
     * – 400 Bad Request si email es inválido
     * – 404 Not Found si no existe
     * – 500 Internal Server Error en errores inesperados
     */
    @GetMapping("/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        if (email == null || email.isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("El parámetro 'email' es obligatorio");
        }
        try {
            User user = userService.getUserByEmail(email);
            if (user == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Usuario con email '" + email + "' no encontrado");
            }
            return ResponseEntity.ok(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al obtener el usuario");
        }
    }

    /**
     * GET /users
     * – 200 OK con lista de usuarios
     * – 500 Internal Server Error en errores inesperados
     */
    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al listar usuarios");
        }
    }

    /**
     * DELETE /users/{id}
     * – 200 OK si se elimina
     * – 404 Not Found si no existe
     * – 500 Internal Server Error en errores inesperados
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity
                    .badRequest()
                    .body("El parámetro 'id' es obligatorio");
        }
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (EmptyResultDataAccessException notFound) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Usuario con ID " + id + " no encontrado");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al eliminar el usuario");
        }
    }
}
