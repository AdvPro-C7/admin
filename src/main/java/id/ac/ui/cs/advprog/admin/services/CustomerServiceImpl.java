package id.ac.ui.cs.advprog.admin.services;
import id.ac.ui.cs.advprog.admin.model.Customer;
import id.ac.ui.cs.advprog.admin.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

        @Autowired
        private CustomerRepository customerRepository;

        @Override
        public List<Customer> getAllCustomers() {
            return customerRepository.findAll();
        }

        @Override
        public Customer getCustomerById(int id) {
            Optional<Customer> customerOptional = customerRepository.findById(id);
            return customerOptional.orElse(null);
        }

        @Override
        public Customer saveOrUpdateCustomer(Customer customer) {
            return customerRepository.save(customer);
        }

        @Override
        public void deleteCustomer(int id) {
            customerRepository.deleteById(id);
        }
    }

