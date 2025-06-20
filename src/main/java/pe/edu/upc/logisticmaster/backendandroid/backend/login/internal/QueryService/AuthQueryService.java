package pe.edu.upc.logisticmaster.backendandroid.backend.login.internal.QueryService;

import org.springframework.stereotype.Service;

@Service
public class AuthQueryService {

    public boolean isTokenValid(String token) {
        // Lógica para verificar si un token es válido
        return true;  // Esto debe implementarse correctamente según el sistema de autenticación
    }
}
