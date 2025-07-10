// src/main/java/pe/edu/upc/logisticmaster/backendandroid/backend/user/internal/queryService/UserQueryService.java
package pe.edu.upc.logisticmaster.backendandroid.backend.user.internal.queryService;

import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model.UserAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.repositories.UserRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.transform.UserDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserQueryService {

    private final UserRepository repo;

    public UserQueryService(UserRepository repo) {
        this.repo = repo;
    }

    /** Lista todos los usuarios */
    public List<UserDto> listAll() {
        return repo.findAll()
                .stream()
                .map(UserAggregate::toDto)
                .collect(Collectors.toList());
    }

    /** Busca por ID */
    public UserDto getById(Long id) {
        UserAggregate agg = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        return agg.toDto();
    }

    /** Busca por username */
    public UserDto getByUsuario(String usuario) {
        UserAggregate agg = repo.findByUsuario(usuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con usuario: " + usuario));
        return agg.toDto();
    }

    /** Busca por email */
    public UserDto getByEmail(String email) {
        UserAggregate agg = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + email));
        return agg.toDto();
    }
}
