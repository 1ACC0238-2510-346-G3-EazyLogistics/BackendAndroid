package pe.edu.upc.logisticmaster.backendandroid.backend.customer.domain.model;

public class CustomerCommand {
    private String id;
    private String name;
    private String email;

    // Constructor con todos los campos
    public CustomerCommand(String id, String name, String email) {
        this.id    = id;
        this.name  = name;
        this.email = email;
    }

    // Getters y Setters

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
