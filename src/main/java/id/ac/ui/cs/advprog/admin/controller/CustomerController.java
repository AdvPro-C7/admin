package id.ac.ui.cs.advprog.admin.controller;
import id.ac.ui.cs.advprog.admin.model.Customer;
import id.ac.ui.cs.advprog.admin.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public CompletableFuture<ResponseEntity<List<Customer>>> getAllCustomers() {
        return customerService.getAllCustomers().thenApply(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<Customer>> getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id).thenApply(customer ->
                customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public CompletableFuture<ResponseEntity<Customer>> saveOrUpdateCustomer(@RequestBody Customer customer) {
        return customerService.saveOrUpdateCustomer(customer).thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> deleteCustomer(@PathVariable int id) {
        return customerService.deleteCustomer(id).thenApply(v -> ResponseEntity.noContent().build());
    }
}