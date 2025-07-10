package pe.edu.upc.logisticmaster.backendandroid.backend.paymentmethod.domain.model;

import jakarta.persistence.*;

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

    public PaymentMethodAggregate() {}

    // Getters & Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Boolean getIsDefault() { return isDefault; }
    public void setIsDefault(Boolean isDefault) { this.isDefault = isDefault; }

    public String getCardType() { return cardType; }
    public void setCardType(String cardType) { this.cardType = cardType; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getCardHolder() { return cardHolder; }
    public void setCardHolder(String cardHolder) { this.cardHolder = cardHolder; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }
}
