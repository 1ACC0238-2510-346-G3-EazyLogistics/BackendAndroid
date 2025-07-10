package pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.transform;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PaymentMethodDto {
    private Long id;
    private Long userId;
    private Boolean isDefault;
    private String cardType;
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private String cvv;
}
