package pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model;

import lombok.Getter;
import lombok.Setter;

public class AuthCommand {
    private String email;
    private String password;

    // Constructor
    public AuthCommand(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Métodos Getters y Setters
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
