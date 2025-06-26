package pe.edu.upc.logisticmaster.backendandroid.backend.login.interfaces.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthCommand authCommand) {
        // 1) Validación de entrada
        if (authCommand.getEmail() == null || authCommand.getEmail().isBlank()
                || authCommand.getPassword() == null || authCommand.getPassword().isBlank()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Debe proporcionar email y password");
        }

        try {
            // 2) Intento de autenticación
            AuthAggregate user = authService.authenticateUser(
                    authCommand.getEmail(),
                    authCommand.getPassword()
            );

            if (user == null) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Email o contraseña incorrectos");
            }

            // 3) OK
            return ResponseEntity.ok(user);

        } catch (Exception ex) {
            // 4) Error inesperado
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ingreso Datos String Default (Prueba Swagger)");
        }
    }
}
