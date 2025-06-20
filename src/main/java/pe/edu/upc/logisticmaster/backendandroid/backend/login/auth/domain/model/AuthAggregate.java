package pe.edu.upc.logisticmaster.backendandroid.backend.login.auth.domain.model;

public class AuthAggregate {
    private String email;
    private String password;

    // Constructor
    public AuthAggregate(String email, String password) {
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
