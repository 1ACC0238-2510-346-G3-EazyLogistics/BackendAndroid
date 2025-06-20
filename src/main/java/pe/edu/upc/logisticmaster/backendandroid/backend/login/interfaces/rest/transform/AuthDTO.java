package pe.edu.upc.logisticmaster.backendandroid.backend.login.interfaces.rest.transform;

import pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model.AuthAggregate;

public class AuthDTO {
    private String email;
    private String password;

    // Constructor
    public AuthDTO(AuthAggregate authAggregate) {
        this.email = authAggregate.getEmail();
        this.password = authAggregate.getPassword();
    }

    // Getters y Setters
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
