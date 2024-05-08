package id.ac.ui.cs.advprog.admin.services;
import id.ac.ui.cs.advprog.admin.dto.CustomerDto;
import id.ac.ui.cs.advprog.admin.model.Customer;
import id.ac.ui.cs.advprog.admin.repository.CustomerRepository;
import id.ac.ui.cs.advprog.admin.services.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl {

        @Autowired
        private CustomerRepository customerRepository;

        @Override
        public List<CustomerDTO> getAllCustomers() {
            return customerRepository.findAll().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }

        @Override
        public CustomerDTO getCustomerById(Long id) {
            Customer customer = customerRepository.findById(id).orElse(null);
            return convertToDTO(customer);
        }

        @Override
        public CustomerDTO createCustomer(CustomerDTO customerDTO) {
            Customer customer = convertToEntity(customerDTO);
            Customer savedCustomer = customerRepository.save(customer);
            return convertToDTO(savedCustomer);
        }

        @Override
        public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
            Customer existingCustomer = customerRepository.findById(id).orElse(null);
            if (existingCustomer != null) {
                BeanUtils.copyProperties(customerDTO, existingCustomer);
                Customer updatedCustomer = customerRepository.save(existingCustomer);
                return convertToDTO(updatedCustomer);
            }
            return null;
        }

        @Override
        public void deleteCustomer(Long id) {
            customerRepository.deleteById(id);
        }

        private CustomerDTO convertToDTO(Customer customer) {
            CustomerDTO customerDTO = new CustomerDTO();
            BeanUtils.copyProperties(customer, customerDTO);
            return customerDTO;
        }

        private Customer convertToEntity(CustomerDTO customerDTO) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDTO, customer);
            return customer;
        }
    }

