package pe.edu.upc.logisticmaster.backendandroid.backend.customer.domain.model;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    // Lógica de negocio relacionada con el cliente (por ejemplo, validaciones adicionales)
    public void createCustomer(CustomerCommand command) {
        // Lógica para crear un cliente
    }

    public CustomerAggregate getCustomerById(String id) {
        // Lógica para obtener un cliente por ID
        return new CustomerAggregate();
    }
}
