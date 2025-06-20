package pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class AuthAggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

    // Constructor vacío requerido por JPA
    protected AuthAggregate() {}

    public AuthAggregate(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
