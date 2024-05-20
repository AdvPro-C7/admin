package id.ac.ui.cs.advprog.admin.services;
import id.ac.ui.cs.advprog.admin.model.Customer;
import id.ac.ui.cs.advprog.admin.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerServiceImpl implements CustomerService {

        @Autowired
        private CustomerRepository customerRepository;

        @Override
        public CompletableFuture<List<Customer>> getAllCustomers() {
            return CompletableFuture.supplyAsync(() -> customerRepository.findAll());
        }

        @Override
        public CompletableFuture<Customer> getCustomerById(int id) {
            return CompletableFuture.supplyAsync(() -> customerRepository.findById((long) id).orElse(null));
        }

        @Override
        public CompletableFuture<Customer> saveOrUpdateCustomer(Customer customer) {
            return CompletableFuture.supplyAsync(() -> customerRepository.save(customer));
        }

        @Override
        public CompletableFuture<Void> deleteCustomer(int id) {
            return CompletableFuture.runAsync(() -> customerRepository.deleteById((long) id));
        }

    public CompletableFuture<Void> giveWarning(int customerId) {
        return CompletableFuture.runAsync(() -> {
            Customer customer = customerRepository.findById((long) customerId).orElse(null);
            if (customer != null) {
                int warningCount = customer.getWarningCount();
                warningCount++;
                customer.setWarningCount(warningCount);
                if (warningCount >= 3) {
                    customerRepository.deleteById((long) customerId);
                } else {
                    customerRepository.save(customer);
                }
            }
        });
      }
    }

