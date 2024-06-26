package id.ac.ui.cs.advprog.admin.controller;
import id.ac.ui.cs.advprog.admin.model.Customer;
import id.ac.ui.cs.advprog.admin.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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

    @PostMapping("/warn/{id}")
    public CompletableFuture<ResponseEntity<Customer>> warnCustomer(@PathVariable int id) {
        return customerService.getCustomerById(id).thenCompose(customer -> {
            if (customer == null) {
                return CompletableFuture.completedFuture(ResponseEntity.notFound().build());
            }
            customer.setWarnings(customer.getWarnings() + 1);
            return customerService.saveOrUpdateCustomer(customer).thenApply(ResponseEntity::ok);
        });

    }
}