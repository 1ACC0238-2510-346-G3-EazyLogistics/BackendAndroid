package pe.edu.upc.logisticmaster.backendandroid.backend.user.internal.commandService;

import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model.UserAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.repositories.UserRepository;

@Service
public class UserCommandService {

    private final UserRepository repo;

    public UserCommandService(UserRepository repo) {
        this.repo = repo;
    }

    public UserAggregate create(UserAggregate u) {
        return repo.save(u);
    }

    public UserAggregate update(Long id, UserAggregate u) {
        u.setId(id);
        return repo.save(u);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}