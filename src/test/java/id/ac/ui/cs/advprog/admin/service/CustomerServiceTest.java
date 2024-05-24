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
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

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
        Customer customer1 = new Customer.Builder().setId(1).setName("John Doe").setEmail("john@example.com").build();
        Customer customer2 = new Customer.Builder().setId(2).setName("Jane Doe").setEmail("jane@example.com").build();
        List<Customer> customers = Arrays.asList(customer1, customer2);

        when(customerRepository.findAll()).thenReturn(customers);

        CompletableFuture<List<Customer>> result = customerService.getAllCustomers();
        assertNotNull(result);
        assertEquals(2, result.join().size());
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
    }
}
