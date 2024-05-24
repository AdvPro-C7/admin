package id.ac.ui.cs.advprog.admin.service;

import id.ac.ui.cs.advprog.admin.model.Customer;
import id.ac.ui.cs.advprog.admin.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCustomers() {
        // Similar to CustomerServiceTest but focused on implementation details if any
    }

    @Test
    void testGetCustomerById() {
        Customer customer = new Customer.Builder().setId(1).setName("John Doe").setEmail("john@example.com").build();

        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        CompletableFuture<Customer> result = customerService.getCustomerById(1);
        assertNotNull(result);
        assertEquals("John Doe", result.join().getName());
    }

    @Test
    void testSaveOrUpdateCustomer() {
        Customer customer = new Customer.Builder().setId(1).setName("John Doe").setEmail("john@example.com").build();

        when(customerRepository.save(customer)).thenReturn(customer);

        CompletableFuture<Customer> result = customerService.saveOrUpdateCustomer(customer);
        assertNotNull(result);
        assertEquals("John Doe", result.join().getName());
    }

    @Test
    void testDeleteCustomer() {
        CompletableFuture<Void> result = customerService.deleteCustomer(1);
        assertNotNull(result);
        assertDoesNotThrow(() -> result.join());
        verify(customerRepository, times(1)).deleteById(1);
    }
}
