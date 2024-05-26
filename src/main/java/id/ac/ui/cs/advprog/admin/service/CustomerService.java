package id.ac.ui.cs.advprog.admin.service;
import id.ac.ui.cs.advprog.admin.model.Customer;

import java.util.concurrent.CompletableFuture;
import java.util.List;


public interface CustomerService {
    CompletableFuture<List<Customer>> getAllCustomers();
    CompletableFuture<Customer> getCustomerById(int id);
    CompletableFuture<Customer> saveOrUpdateCustomer(Customer customer);
    CompletableFuture<Void> deleteCustomer(int id);
}