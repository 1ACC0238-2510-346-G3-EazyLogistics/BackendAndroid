package pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.domain.model.PaymentMethodAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.repositories.PaymentMethodRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.transform.PaymentMethodDto;

import java.util.List;

@Service
public class PaymentMethodCommandService {

    private final PaymentMethodRepository repo;

    public PaymentMethodCommandService(PaymentMethodRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public PaymentMethodDto create(PaymentMethodDto dto) {
        // Si se marca por defecto, limpiar anteriores
        if (Boolean.TRUE.equals(dto.getIsDefault())) {
            List<PaymentMethodAggregate> list = repo.findByUserId(dto.getUserId());
            for (PaymentMethodAggregate pm : list) {
                if (Boolean.TRUE.equals(pm.getIsDefault())) {
                    pm.setIsDefault(false);
                    repo.save(pm);
                }
            }
        }

        PaymentMethodAggregate agg = PaymentMethodAggregate.fromDtoForCreation(dto);
        agg = repo.save(agg);

        return agg.toDto();
    }

    @Transactional
    public PaymentMethodDto update(Long id, PaymentMethodDto dto) {
        PaymentMethodAggregate agg = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PaymentMethod not found: " + id));

        // si marcamos por defecto, desmarcar otros
        if (Boolean.TRUE.equals(dto.getIsDefault()) && !Boolean.TRUE.equals(agg.getIsDefault())) {
            List<PaymentMethodAggregate> list = repo.findByUserId(dto.getUserId());
            for (PaymentMethodAggregate pm : list) {
                if (Boolean.TRUE.equals(pm.getIsDefault())) {
                    pm.setIsDefault(false);
                    repo.save(pm);
                }
            }
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
    public void deleteByUser(Long userId, Long id) {
        repo.deleteByUserIdAndId(userId, id);
    }

    @Transactional
    public PaymentMethodDto setDefault(Long userId, Long id) {
        // desmarca todos
        List<PaymentMethodAggregate> list = repo.findByUserId(userId);
        for (PaymentMethodAggregate pm : list) {
            if (Boolean.TRUE.equals(pm.getIsDefault())) {
                pm.setIsDefault(false);
                repo.save(pm);
            }
        }
        // marca elegido
        PaymentMethodAggregate chosen = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PaymentMethod not found: " + id));
        chosen.setIsDefault(true);
        repo.save(chosen);

        // mapear a DTO
        PaymentMethodDto dto = new PaymentMethodDto();
        dto.setId(chosen.getId());
        dto.setUserId(chosen.getUserId());
        dto.setIsDefault(chosen.getIsDefault());
        dto.setCardType(chosen.getCardType());
        dto.setCardNumber(chosen.getCardNumber());
        dto.setCardHolder(chosen.getCardHolder());
        dto.setExpiryDate(chosen.getExpiryDate());
        dto.setCvv(chosen.getCvv());
        return dto;
    }
}
