// src/main/java/pe/edu/upc/logisticmaster/backendandroid/backend/login/auth/domain/model/AuthAggregate.java
package pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "auth_aggregate")
public class AuthAggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public AuthAggregate() {}

    public AuthAggregate(String email, String password) {
        this.email    = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
