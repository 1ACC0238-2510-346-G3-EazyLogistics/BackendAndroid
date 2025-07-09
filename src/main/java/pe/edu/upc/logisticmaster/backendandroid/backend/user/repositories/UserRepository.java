package pe.edu.upc.logisticmaster.backendandroid.backend.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model.UserAggregate;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAggregate, Long> {
    Optional<UserAggregate> findByUsuario(String email);
}