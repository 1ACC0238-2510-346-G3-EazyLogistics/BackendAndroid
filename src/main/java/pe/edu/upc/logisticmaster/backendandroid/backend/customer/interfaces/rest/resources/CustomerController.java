package pe.edu.upc.logisticmaster.backendandroid.backend.customer.interfaces.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.customer.domain.model.CustomerCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.customer.domain.model.CustomerService;
import pe.edu.upc.logisticmaster.backendandroid.backend.customer.interfaces.rest.transform.CustomerDto;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public void createCustomer(@RequestBody CustomerCommand command) {
        customerService.createCustomer(command);
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable String id) {

        return new CustomerDto(customerService.getCustomerById(id));
    }
}
