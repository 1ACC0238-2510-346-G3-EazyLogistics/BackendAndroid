package pe.edu.upc.logisticmaster.backendandroid.backend.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthAggregate;

public interface AuthRepository extends JpaRepository<AuthAggregate, Long> {

    boolean existsByEmailAndPassword(String email, String password);
}
