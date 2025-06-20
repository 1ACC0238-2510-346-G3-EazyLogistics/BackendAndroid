package pe.edu.upc.logisticmaster.backendandroid.backend.customer.domain.model;

public class CustomerAggregate {
    private String id;
    private String name;
    private String email;

    // Métodos de negocio relacionados con el cliente (por ejemplo, validaciones)
    public boolean isValidCustomer() {
        // Lógica para validar al cliente
        return !this.name.isEmpty() && this.email.contains("@");
    }

    // Métodos Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
