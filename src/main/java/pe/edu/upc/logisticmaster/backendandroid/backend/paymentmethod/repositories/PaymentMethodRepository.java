package pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.repositories;

import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.domain.model.PaymentMethodAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethodAggregate, Long> {
    List<PaymentMethodAggregate> findByUserId(Long userId);
    Optional<PaymentMethodAggregate> findByUserIdAndIsDefaultTrue(Long userId);
    boolean existsByUserIdAndId(Long userId, Long id);
    void deleteByUserIdAndId(Long userId, Long id);
}
