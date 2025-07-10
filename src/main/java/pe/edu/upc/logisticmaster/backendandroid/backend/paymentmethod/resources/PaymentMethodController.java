package pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.transform.PaymentMethodDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.domain.services.PaymentMethodCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.domain.services.PaymentMethodQueryService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentMethodController {

    private final PaymentMethodCommandService command;
    private final PaymentMethodQueryService query;

    // — CRUD por usuario
    @GetMapping("/users/{userId}/payment-methods")
    public List<PaymentMethodDto> listByUser(@PathVariable Long userId) {
        return query.findByUserId(userId);
    }

    @GetMapping("/users/{userId}/payment-methods/{id}")
    public PaymentMethodDto get(
            @PathVariable Long userId,
            @PathVariable Long id
    ) {
        return query.findById(id);
    }

    @PostMapping("/users/{userId}/payment-methods")
    public ResponseEntity<PaymentMethodDto> create(
            @PathVariable Long userId,
            @RequestBody PaymentMethodDto dto
    ) {
        dto.setUserId(userId);
        PaymentMethodDto created = command.create(dto);
        return ResponseEntity
                .created(URI.create("/users/" + userId + "/payment-methods/" + created.getId()))
                .body(created);
    }

    @PutMapping("/users/{userId}/payment-methods/{id}")
    public PaymentMethodDto update(
            @PathVariable Long userId,
            @PathVariable Long id,
            @RequestBody PaymentMethodDto dto
    ) {
        dto.setUserId(userId);
        return command.update(id, dto);
    }

    @DeleteMapping("/users/{userId}/payment-methods/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long userId,
            @PathVariable Long id
    ) {
        command.deleteByUser(userId, id);
        return ResponseEntity.noContent().build();
    }

    // — Endpoints globales

    @GetMapping("/payment-methods")
    public List<PaymentMethodDto> listAll() {
        return query.findAll();
    }

    // — Operaciones por usuario

    /** Obtener mtodo por defecto */
    @GetMapping("/users/{userId}/payment-methods/default")
    public PaymentMethodDto getDefault(@PathVariable Long userId) {
        return query.findDefaultByUserId(userId);
    }

    /** Marcar uno como por defecto */
    @PatchMapping("/users/{userId}/payment-methods/{id}/default")
    public ResponseEntity<PaymentMethodDto> setDefault(
            @PathVariable Long userId,
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(command.setDefault(userId, id));
    }

    /** Comprueba si existe para este usuario */
    @GetMapping("/users/{userId}/payment-methods/{id}/exists")
    public ResponseEntity<Boolean> exists(
            @PathVariable Long userId,
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(query.exists(userId, id));
    }
}
