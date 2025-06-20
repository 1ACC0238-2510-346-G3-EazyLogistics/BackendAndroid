package pe.edu.upc.logisticmaster.backendandroid.backend.login.internal.commandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthService;

@Service
public class AuthCommandService {

    @Autowired
    private AuthService authService;

    public boolean executeLogin(AuthCommand command) {
        return authService.authenticateUser(command);
    }
}
