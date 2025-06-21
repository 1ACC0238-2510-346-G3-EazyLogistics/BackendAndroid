package pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.repositories.AuthRepository;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public AuthAggregate authenticateUser(String email, String password) {
        return authRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    public boolean authenticateUser(AuthCommand command) {
        return false;
    }
}
