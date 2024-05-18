package id.ac.ui.cs.advprog.admin.services;
import id.ac.ui.cs.advprog.admin.model.Customer;
import id.ac.ui.cs.advprog.admin.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CustomerServiceImpl implements CustomerService {

        @Autowired
        private CustomerRepository customerRepository;
        private final Executor executor = Executors.newFixedThreadPool(10);

        @Override
        public CompletableFuture<List<Customer>> getAllCustomers() {
            return CompletableFuture.supplyAsync(() -> customerRepository.findAll(), executor);
        }

        @Override
        public CompletableFuture<Customer> getCustomerById(int id) {
            return CompletableFuture.supplyAsync(() -> {
                Optional<Customer> customerOptional = customerRepository.findById((long) id);
                return customerOptional.orElse(null);
            }, executor);
        }

        @Override
        public CompletableFuture<Customer> saveOrUpdateCustomer(Customer customer) {
            return CompletableFuture.supplyAsync(() -> customerRepository.save(customer), executor);
        }

        @Override
        public CompletableFuture<Void> deleteCustomer(int id) {
            return CompletableFuture.runAsync(() -> customerRepository.deleteById((long) id), executor);
        }
    }

