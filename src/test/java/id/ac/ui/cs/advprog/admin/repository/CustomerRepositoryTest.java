package id.ac.ui.cs.advprog.admin.repository;

import id.ac.ui.cs.advprog.admin.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Example;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DataJpaTest
public class CustomerRepositoryTest {

    @Mock
    private TestEntityManager entityManager;

    @InjectMocks
    private CustomerRepository customerRepository;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer.Builder()
                .setId(1)
                .setName("John Doe")
                .setEmail("john@example.com")
                .build();
        when(entityManager.persist(customer)).thenReturn(customer);
    }

    @Test
    void testSaveCustomer() {
        Customer savedCustomer = customerRepository.save(customer);
        assertNotNull(savedCustomer);
        assertEquals(customer.getId(), savedCustomer.getId());
    }

    @Test
    void testFindById() {
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
        Optional<Customer> foundCustomer = customerRepository.findById(1);
        assertTrue(foundCustomer.isPresent());
        assertEquals("John Doe", foundCustomer.get().getName());
    }

    @Test
    void testFindByIdNotFound() {
        when(customerRepository.findById(1)).thenReturn(Optional.empty());
        Optional<Customer> foundCustomer = customerRepository.findById(1);
        assertFalse(foundCustomer.isPresent());
    }

    @Test
    void testDeleteCustomer() {
        doNothing().when(entityManager).remove(customer);
        customerRepository.deleteById(customer.getId());
        verify(customerRepository, times(1)).deleteById(customer.getId());
    }

    @Test
    void testExampleQuery() {
        Example<Customer> example = Example.of(new Customer.Builder().setName("John Doe").build());
        when(customerRepository.findOne(example)).thenReturn(Optional.of(customer));
        Optional<Customer> result = customerRepository.findOne(example);
        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getName());
    }
}
