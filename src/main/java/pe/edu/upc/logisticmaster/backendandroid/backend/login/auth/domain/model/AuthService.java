package pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.repositories.AuthRepository;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public boolean authenticateUser(AuthCommand command) {
        // Verifica las credenciales con la base de datos
        return authRepository.existsByEmailAndPassword(command.getEmail(), command.getPassword());
    }
}
