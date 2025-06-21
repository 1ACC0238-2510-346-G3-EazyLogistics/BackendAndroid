package pe.edu.upc.logisticmaster.backendandroid.backend.login.interfaces.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/Login")
    public AuthAggregate login(@RequestBody AuthCommand authCommand) {
        // Desempaquetamos el email y la contraseña del comando
        String email = authCommand.getEmail();
        String password = authCommand.getPassword();

        // Llamamos al servicio de autenticación
        return authService.authenticateUser(email, password);
    }
}
