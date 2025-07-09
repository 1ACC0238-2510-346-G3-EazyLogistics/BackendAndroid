package pe.edu.upc.logisticmaster.backendandroid.backend.user.internal.commandService;

import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.repositories.UserRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model.UserAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.transform.UserDto;

@Service
public class UserCommandService {

    private final UserRepository repo;

    public UserCommandService(UserRepository repo) {
        this.repo = repo;
    }

    /** Crea un nuevo usuario */
    public UserDto create(UserDto dto) {
        UserAggregate agg = new UserAggregate(
                null,
                dto.getNombre(),
                dto.getApellido(),
                dto.getUsuario(),
                dto.getEmail(),
                dto.getContraseña()
        );
        UserAggregate saved = repo.save(agg);
        return saved.toDto();
    }

    /** Actualiza un usuario existente */
    public UserDto update(Long id, UserDto dto) {
        UserAggregate existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));

        existing.setNombre(dto.getNombre());
        existing.setApellido(dto.getApellido());
        existing.setUsuario(dto.getUsuario());
        existing.setEmail(dto.getEmail());
        existing.setContraseña(dto.getContraseña());

        UserAggregate updated = repo.save(existing);
        return updated.toDto();
    }

    /** Elimina un usuario por ID */
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
