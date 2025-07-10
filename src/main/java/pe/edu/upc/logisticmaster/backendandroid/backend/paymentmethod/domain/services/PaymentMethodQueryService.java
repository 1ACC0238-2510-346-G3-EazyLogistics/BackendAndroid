package pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.domain.services;

import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.domain.model.PaymentMethodAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.repositories.PaymentMethodRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.transform.PaymentMethodDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentMethodQueryService {

    private final PaymentMethodRepository repo;

    public PaymentMethodQueryService(PaymentMethodRepository repo) {
        this.repo = repo;
    }

    public PaymentMethodDto findById(Long id) {
        PaymentMethodAggregate agg = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PaymentMethod not found: " + id));
        return toDto(agg);
    }

    public List<PaymentMethodDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<PaymentMethodDto> findByUserId(Long userId) {
        return repo.findByUserId(userId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public PaymentMethodDto findDefaultByUserId(Long userId) {
        Optional<PaymentMethodAggregate> opt = repo.findByUserIdAndIsDefaultTrue(userId);
        PaymentMethodAggregate agg = opt.orElseThrow(
                () -> new IllegalArgumentException("No default payment method for user: " + userId)
        );
        return toDto(agg);
    }

    public boolean exists(Long userId, Long id) {
        return repo.existsByUserIdAndId(userId, id);
    }

    private PaymentMethodDto toDto(PaymentMethodAggregate agg) {
        PaymentMethodDto dto = new PaymentMethodDto();
        dto.setId(agg.getId());
        dto.setUserId(agg.getUserId());
        dto.setIsDefault(agg.getIsDefault());
        dto.setCardType(agg.getCardType());
        dto.setCardNumber(agg.getCardNumber());
        dto.setCardHolder(agg.getCardHolder());
        dto.setExpiryDate(agg.getExpiryDate());
        dto.setCvv(agg.getCvv());
        return dto;
    }
}
