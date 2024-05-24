package id.ac.ui.cs.advprog.admin.service;

import id.ac.ui.cs.advprog.admin.model.Customer;
import id.ac.ui.cs.advprog.admin.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCustomers() throws ExecutionException, InterruptedException {
        Customer customer1 = new Customer(1, "Customer 1", "email1@example.com", 123456, 0);
        Customer customer2 = new Customer(2, "Customer 2", "email2@example.com", 654321, 0);
        List<Customer> customerList = Arrays.asList(customer1, customer2);

        when(customerRepository.findAll()).thenReturn(customerList);

        List<Customer> result = customerService.getAllCustomers().get();

        assertEquals(2, result.size());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void testGetCustomerById() throws ExecutionException, InterruptedException {
        Customer customer = new Customer(1, "Customer 1", "email1@example.com", 123456, 0);

        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        Customer result = customerService.getCustomerById(1).get();

        assertNotNull(result);
        assertEquals("Customer 1", result.getName());
        verify(customerRepository, times(1)).findById(1);
    }

    @Test
    void testSaveOrUpdateCustomer() throws ExecutionException, InterruptedException {
        Customer customer = new Customer(1, "Customer 1", "email1@example.com", 123456, 0);

        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer result = customerService.saveOrUpdateCustomer(customer).get();

        assertNotNull(result);
        assertEquals("Customer 1", result.getName());
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void testDeleteCustomer() throws ExecutionException, InterruptedException {
        doNothing().when(customerRepository).deleteById(1);

        customerService.deleteCustomer(1).get();

        verify(customerRepository, times(1)).deleteById(1);
    }
}
