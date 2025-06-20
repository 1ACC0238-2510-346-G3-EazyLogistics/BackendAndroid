package pe.edu.upc.logisticmaster.backendandroid.backend.customer.interfaces.rest.transform;

import pe.edu.upc.logisticmaster.backendandroid.backend.customer.domain.model.CustomerAggregate;

public class CustomerDto {
    private String id;
    private String name;
    private String email;

    public CustomerDto(CustomerAggregate customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
    }

    // Getters y Setters
}