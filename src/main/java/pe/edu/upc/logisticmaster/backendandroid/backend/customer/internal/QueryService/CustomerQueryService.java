package pe.edu.upc.logisticmaster.backendandroid.backend.customer.internal.QueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.customer.domain.model.CustomerCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.customer.interfaces.rest.transform.CustomerDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.customer.domain.model.CustomerService;

@Service
public class CustomerQueryService {

    @Autowired
    private CustomerService customerService;

    public CustomerDto getCustomerById(String id) {
        return new CustomerDto(customerService.getCustomerById(id));
    }

    public void executeCreateCustomer(CustomerCommand command) {
    }


}
