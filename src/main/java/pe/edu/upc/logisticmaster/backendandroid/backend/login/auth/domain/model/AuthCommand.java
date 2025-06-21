package pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthCommand {
    // Getters y Setters
    private String email;
    private String password;

    // Constructor
    public AuthCommand(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
