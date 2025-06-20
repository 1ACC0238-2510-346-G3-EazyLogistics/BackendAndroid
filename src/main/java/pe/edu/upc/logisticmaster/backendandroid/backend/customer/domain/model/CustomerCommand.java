package pe.edu.upc.logisticmaster.backendandroid.backend.customer.domain.model;

public class CustomerCommand {
    private String id;
    private String name;
    private String email;

    // Constructor, Getters y Setters
    public CustomerCommand(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Métodos de comando (por ejemplo, crear un cliente)
}
