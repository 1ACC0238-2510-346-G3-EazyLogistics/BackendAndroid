package pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.domain.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.domain.model.PaymentMethodAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.repositories.PaymentMethodRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.transform.PaymentMethodDto;

@Service
@RequiredArgsConstructor
public class PaymentMethodCommandService {

    private final PaymentMethodRepository repo;

    @Transactional
    public PaymentMethodDto create(PaymentMethodDto dto) {
        // Si se marca por defecto, limpiar anteriores
        if (Boolean.TRUE.equals(dto.getIsDefault())) {
            repo.findByUserId(dto.getUserId()).stream()
                    .filter(PaymentMethodAggregate::getIsDefault)
                    .forEach(pm -> {
                        pm.setIsDefault(false);
                        repo.save(pm);
                    });
        }
        PaymentMethodAggregate agg = PaymentMethodAggregate.builder()
                .userId(dto.getUserId())
                .isDefault(dto.getIsDefault())
                .cardType(dto.getCardType())
                .cardNumber(dto.getCardNumber())
                .cardHolder(dto.getCardHolder())
                .expiryDate(dto.getExpiryDate())
                .cvv(dto.getCvv())
                .build();
        agg = repo.save(agg);
        dto.setId(agg.getId());
        return dto;
    }

    @Transactional
    public PaymentMethodDto update(Long id, PaymentMethodDto dto) {
        PaymentMethodAggregate agg = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PaymentMethod not found: " + id));
        // si llegase marcado por defecto, desmarcar otros
        if (Boolean.TRUE.equals(dto.getIsDefault()) && !agg.getIsDefault()) {
            repo.findByUserId(dto.getUserId()).stream()
                    .filter(PaymentMethodAggregate::getIsDefault)
                    .forEach(pm -> {
                        pm.setIsDefault(false);
                        repo.save(pm);
                    });
        }
        agg.setIsDefault(dto.getIsDefault());
        agg.setCardType(dto.getCardType());
        agg.setCardNumber(dto.getCardNumber());
        agg.setCardHolder(dto.getCardHolder());
        agg.setExpiryDate(dto.getExpiryDate());
        agg.setCvv(dto.getCvv());
        repo.save(agg);
        return dto;
    }

    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public void deleteByUser(Long userId, Long id) {
        repo.deleteByUserIdAndId(userId, id);
    }

    @Transactional
    public PaymentMethodDto setDefault(Long userId, Long id) {
        // desmarca todos
        repo.findByUserId(userId).stream()
                .filter(PaymentMethodAggregate::getIsDefault)
                .forEach(pm -> {
                    pm.setIsDefault(false);
                    repo.save(pm);
                });
        // marca el elegido
        PaymentMethodAggregate chosen = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PaymentMethod not found: " + id));
        chosen.setIsDefault(true);
        repo.save(chosen);
        return toDto(chosen);
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
