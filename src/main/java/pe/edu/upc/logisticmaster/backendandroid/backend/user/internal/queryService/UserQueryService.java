package pe.edu.upc.logisticmaster.backendandroid.backend.user.internal.queryService;

import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model.UserAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.repositories.UserRepository;

import java.util.List;

@Service
public class UserQueryService {

    private final UserRepository repo;

    public UserQueryService(UserRepository repo) {
        this.repo = repo;
    }

    public List<UserAggregate> findAll() {
        return repo.findAll();
    }

    public UserAggregate findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));
    }
}