package id.ac.ui.cs.advprog.admin.services;
import id.ac.ui.cs.advprog.admin.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

        @Autowired
        private id.ac.ui.cs.advprog.admin.dto.CustomerRepository customerRepository;

        @Override
        public List<Customer> getAllCustomers() {
            return customerRepository.findAll();
        }

        @Override
        public Customer getCustomerById(int id) {
            Optional<Customer> customerOptional = customerRepository.findById((long) id);
            return customerOptional.orElse(null);
        }

        @Override
        public Customer saveOrUpdateCustomer(Customer customer) {
            return customerRepository.save(customer);
        }

        @Override
        public void deleteCustomer(int id) {
            customerRepository.deleteById((long) id);
        }
    }

