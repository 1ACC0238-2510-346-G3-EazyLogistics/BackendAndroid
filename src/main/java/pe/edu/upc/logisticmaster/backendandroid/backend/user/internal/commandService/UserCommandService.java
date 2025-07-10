// src/main/java/pe/edu/upc/logisticmaster/backendandroid/backend/user/internal/commandService/UserCommandService.java
package pe.edu.upc.logisticmaster.backendandroid.backend.user.internal.commandService;

import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model.UserAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.repositories.UserRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.transform.UserDto;

@Service
public class UserCommandService {

    private final UserRepository repo;

    public UserCommandService(UserRepository repo) {
        this.repo = repo;
    }

    /** Crea un usuario */
    public UserDto create(UserDto dto) {
        UserAggregate agg = UserAggregate.fromDto(dto);
        UserAggregate saved = repo.save(agg);
        return saved.toDto();
    }

    /** Actualiza por ID */
    public UserDto updateById(UserDto dto) {
        if (!repo.existsById(dto.getId())) {
            throw new RuntimeException("No existe usuario con id: " + dto.getId());
        }
        UserAggregate agg = UserAggregate.fromDto(dto);
        UserAggregate saved = repo.save(agg);
        return saved.toDto();
    }

    /** Actualiza por email */
    public UserDto updateByEmail(UserDto dto) {
        UserAggregate existing = repo.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("No existe usuario con email: " + dto.getEmail()));
        dto.setId(existing.getId());
        UserAggregate agg = UserAggregate.fromDto(dto);
        UserAggregate saved = repo.save(agg);
        return saved.toDto();
    }

    /** Elimina por ID */
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("No existe usuario con id: " + id);
        }
        repo.deleteById(id);
    }
}
