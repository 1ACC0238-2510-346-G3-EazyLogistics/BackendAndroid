package pe.edu.upc.logisticmaster.backendandroid.backend.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthAggregate;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<AuthAggregate, Long> {

    // Verificar si existe un usuario con el email y la contraseña proporcionados
    boolean existsByEmailAndPassword(String email, String password);

    // Obtener un usuario por email y contraseña, si existe
    Optional<AuthAggregate> findByEmailAndPassword(String email, String password);
}
