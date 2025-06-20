package pe.edu.upc.logisticmaster.backendandroid.backend.login.interfaces.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public boolean login(@RequestBody AuthCommand authCommand) {
        return authService.authenticateUser(authCommand);
    }
}
