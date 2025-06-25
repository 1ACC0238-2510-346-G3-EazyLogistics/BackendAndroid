package pe.edu.upc.logisticmaster.backendandroid.backend.customer.internal.commandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.customer.domain.model.CustomerCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.customer.domain.model.CustomerService;

@Service
public class CustomerCommandService {

    @Autowired
    private CustomerService customerService;

    // Método para ejecutar la creación de un cliente
    public void executeCreateCustomer(CustomerCommand command) {
        customerService.createCustomer(command);
    }

    // Otros métodos para ejecutar actualizaciones, eliminaciones, etc.
}
