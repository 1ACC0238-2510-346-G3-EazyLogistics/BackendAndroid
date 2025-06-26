package pe.edu.upc.logisticmaster.backendandroid.backend.customer.interfaces.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.logisticmaster.backendandroid.backend.customer.domain.model.CustomerCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.customer.internal.QueryService.CustomerQueryService;
import pe.edu.upc.logisticmaster.backendandroid.backend.customer.internal.commandService.CustomerCommandService;
import pe.edu.upc.logisticmaster.backendandroid.backend.customer.interfaces.rest.transform.CustomerDto;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerQueryService customerQueryService;

    @Autowired
    private CustomerCommandService customerCommandService;

    /**
     * GET /customers/{id}
     * - 200 OK con CustomerDto
     * - 400 Bad Request si id es nulo o vacío
     * - 404 Not Found si no existe
     * - 500 Internal Server Error en excepciones
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable String id) {
        if (id == null || id.isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("El parámetro 'id' es obligatorio");
        }
        try {
            CustomerDto dto = customerQueryService.getCustomerById(id);
            if (dto == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Cliente con ID '" + id + "' no encontrado");
            }
            return ResponseEntity.ok(dto);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al obtener el cliente");
        }
    }

    /**
     * POST /customers
     * - 201 Created si se crea con éxito
     * - 400 Bad Request si faltan datos obligatorios
     * - 500 Internal Server Error en excepciones
     */
    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CustomerCommand command) {
        // Validación básica
        if (command == null
                || command.getId() == null || command.getId().isBlank()
                || command.getName() == null || command.getName().isBlank()
                || command.getEmail() == null || command.getEmail().isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("Faltan campos obligatorios: id, name, email");
        }
        try {
            customerCommandService.executeCreateCustomer(command);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al crear el cliente");
        }
    }
}
