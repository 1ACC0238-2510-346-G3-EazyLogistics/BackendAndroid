package pe.edu.upc.logisticmaster.backendandroid.backend.customer.interfaces.rest.resources;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.logisticmaster.backendandroid.backend.customer.domain.model.CustomerCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.customer.interfaces.rest.transform.CustomerDto;
import pe.edu.upc.logisticmaster.backendandroid.backend.customer.internal.QueryService.CustomerQueryService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerQueryService customerQueryService;

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable String id) {
        return customerQueryService.getCustomerById(id);
    }

    @PostMapping
    public void createCustomer(@RequestBody CustomerCommand command) {
        customerQueryService.executeCreateCustomer(command);
    }

}
