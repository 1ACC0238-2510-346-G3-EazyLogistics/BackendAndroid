package pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment_method")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PaymentMethodAggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Boolean isDefault;

    @Column(length = 50, nullable = false)
    private String cardType;

    @Column(length = 19, nullable = false)
    private String cardNumber;

    @Column(length = 255, nullable = false)
    private String cardHolder;

    /** formato MM/YY */
    @Column(length = 7, nullable = false)
    private String expiryDate;

    @Column(length = 4, nullable = false)
    private String cvv;
}
