package pe.edu.upc.logisticmaster.backendandroid.backend.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model.UserAggregate;

public interface UserRepository extends JpaRepository<UserAggregate, Long> { }