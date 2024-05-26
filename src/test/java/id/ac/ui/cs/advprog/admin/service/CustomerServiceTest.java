package id.ac.ui.cs.advprog.admin.service;

import id.ac.ui.cs.advprog.admin.model.Customer;
import id.ac.ui.cs.advprog.admin.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCustomers() {
        when(customerRepository.findAll()).thenReturn(List.of(
                new Customer.Builder().setId(1).setName("John Doe").setEmail("john.doe@example.com").setPhoneNumber(123456789).setWarnings(0).build(),
                new Customer.Builder().setId(2).setName("Jane Doe").setEmail("jane.doe@example.com").setPhoneNumber(987654321).setWarnings(1).build(),
                new Customer.Builder().setId(3).setName("Alice Smith").setEmail("alice.smith@example.com").setPhoneNumber(234567890).setWarnings(0).build(),
                new Customer.Builder().setId(4).setName("Bob Johnson").setEmail("bob.johnson@example.com").setPhoneNumber(345678901).setWarnings(2).build(),
                new Customer.Builder().setId(5).setName("Charlie Brown").setEmail("charlie.brown@example.com").setPhoneNumber(456789012).setWarnings(0).build()
        ));

        CompletableFuture<List<Customer>> customers = customerService.getAllCustomers();
        assertThat(customers.join()).hasSize(5);
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer.Builder().setId(1).setName("John Doe").setEmail("john.doe@example.com").setPhoneNumber(123456789).setWarnings(0).build();
        when(customerRepository.findById(any(Integer.class))).thenReturn(Optional.of(customer));

        CompletableFuture<Customer> foundCustomer = customerService.getCustomerById(1);
        assertThat(foundCustomer.join()).isEqualTo(customer);
    }

    @Test
    public void testSaveOrUpdateCustomer() {
        Customer customer = new Customer.Builder().setId(1).setName("John Doe").setEmail("john.doe@example.com").setPhoneNumber(123456789).setWarnings(0).build();
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        CompletableFuture<Customer> savedCustomer = customerService.saveOrUpdateCustomer(customer);
        assertThat(savedCustomer.join()).isEqualTo(customer);
    }

    @Test
    public void testDeleteCustomer() {
        doNothing().when(customerRepository).deleteById(any(Integer.class));

        CompletableFuture<Void> result = customerService.deleteCustomer(1);
        result.join();

        verify(customerRepository, times(1)).deleteById(1);
    }
}
