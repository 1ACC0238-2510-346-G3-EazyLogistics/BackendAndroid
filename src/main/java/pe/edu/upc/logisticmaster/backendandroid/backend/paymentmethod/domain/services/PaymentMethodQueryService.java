package pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.domain.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.domain.model.PaymentMethodAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.repositories.PaymentMethodRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.transform.PaymentMethodDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentMethodQueryService {

    private final PaymentMethodRepository repo;

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
        PaymentMethodAggregate agg = repo.findByUserIdAndIsDefaultTrue(userId)
                .orElseThrow(() -> new IllegalArgumentException("No default payment method for user: " + userId));
        return toDto(agg);
    }

    public boolean exists(Long userId, Long id) {
        return repo.existsByUserIdAndId(userId, id);
    }

    private PaymentMethodDto toDto(PaymentMethodAggregate agg) {
        return PaymentMethodDto.builder()
                .id(agg.getId())
                .userId(agg.getUserId())
                .isDefault(agg.getIsDefault())
                .cardType(agg.getCardType())
                .cardNumber(agg.getCardNumber())
                .cardHolder(agg.getCardHolder())
                .expiryDate(agg.getExpiryDate())
                .cvv(agg.getCvv())
                .build();
    }
}
