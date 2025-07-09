package pe.edu.upc.logisticmaster.backendandroid.backend.user.internal.queryService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.repositories.UserRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model.UserAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.transform.UserDto;

@Service
public class UserQueryService {

    private final UserRepository repo;

    public UserQueryService(UserRepository repo) {
        this.repo = repo;
    }

    /** Devuelve todos los usuarios como DTO */
    public List<UserDto> getAll() {
        return repo.findAll().stream()
                .map(UserAggregate::toDto)
                .collect(Collectors.toList());
    }

    /** Devuelve un usuario por su ID */
    public UserDto getById(Long id) {
        UserAggregate agg = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));
        return agg.toDto();
    }

    /** Devuelve un usuario por su nombre de usuario (para login) */
    public UserDto getByUsuario(String usuario) {
        UserAggregate agg = repo.findByUsuario(usuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + usuario));
        return agg.toDto();
    }
}
