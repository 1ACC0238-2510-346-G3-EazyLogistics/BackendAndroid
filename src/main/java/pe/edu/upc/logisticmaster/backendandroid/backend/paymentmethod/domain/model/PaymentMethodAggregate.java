package pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.domain.model;

import jakarta.persistence.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.transform.PaymentMethodDto;

@Entity
@Table(name = "payment_method")
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

    public PaymentMethodAggregate() {
    }

    // Constructor con ID (para actualizaciones)
    public PaymentMethodAggregate(Long id, Long userId, Boolean isDefault, String cardType,
            String cardNumber, String cardHolder, String expiryDate, String cvv) {
        this.id = id;
        this.userId = userId;
        this.isDefault = isDefault;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    // Constructor sin ID (para nuevos payment methods)
    public PaymentMethodAggregate(Long userId, Boolean isDefault, String cardType,
            String cardNumber, String cardHolder, String expiryDate, String cvv) {
        this.userId = userId;
        this.isDefault = isDefault;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    /** Mapea de DTO a Aggregate (para actualizaciones con ID) */
    public static PaymentMethodAggregate fromDto(PaymentMethodDto dto) {
        return new PaymentMethodAggregate(
                dto.getId(),
                dto.getUserId(),
                dto.getIsDefault(),
                dto.getCardType(),
                dto.getCardNumber(),
                dto.getCardHolder(),
                dto.getExpiryDate(),
                dto.getCvv());
    }

    /** Mapea de DTO a Aggregate (para creación sin ID) */
    public static PaymentMethodAggregate fromDtoForCreation(PaymentMethodDto dto) {
        return new PaymentMethodAggregate(
                dto.getUserId(),
                dto.getIsDefault(),
                dto.getCardType(),
                dto.getCardNumber(),
                dto.getCardHolder(),
                dto.getExpiryDate(),
                dto.getCvv());
    }

    /** Mapea de Aggregate a DTO */
    public PaymentMethodDto toDto() {
        PaymentMethodDto dto = new PaymentMethodDto();
        dto.setId(id);
        dto.setUserId(userId);
        dto.setIsDefault(isDefault);
        dto.setCardType(cardType);
        dto.setCardNumber(cardNumber);
        dto.setCardHolder(cardHolder);
        dto.setExpiryDate(expiryDate);
        dto.setCvv(cvv);
        return dto;
    }
}
