package id.ac.ui.cs.advprog.admin.services;
import id.ac.ui.cs.advprog.admin.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import id.ac.ui.cs.advprog.admin.repository.CustomerRepository;
import java.util.concurrent.CompletableFuture;
import java.util.List;


public interface CustomerService {
    CompletableFuture<List<Customer>> getAllCustomers();
    CompletableFuture<Customer> getCustomerById(int id);
    CompletableFuture<Customer> saveOrUpdateCustomer(Customer customer);
    CompletableFuture<Void> deleteCustomer(int id);
    CompletableFuture<Void> giveWarning(int id);
}