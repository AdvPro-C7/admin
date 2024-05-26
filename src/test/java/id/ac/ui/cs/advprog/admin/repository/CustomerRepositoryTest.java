package id.ac.ui.cs.advprog.admin.repository;

import id.ac.ui.cs.advprog.admin.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveAndFindAll() {
        Customer customer1 = new Customer.Builder()
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setPhoneNumber(123456789)
                .setWarnings(0)
                .build();
        Customer customer2 = new Customer.Builder()
                .setName("Jane Doe")
                .setEmail("jane.doe@example.com")
                .setPhoneNumber(987654321)
                .setWarnings(1)
                .build();
        Customer customer3 = new Customer.Builder()
                .setName("Alice Smith")
                .setEmail("alice.smith@example.com")
                .setPhoneNumber(234567890)
                .setWarnings(0)
                .build();
        Customer customer4 = new Customer.Builder()
                .setName("Bob Johnson")
                .setEmail("bob.johnson@example.com")
                .setPhoneNumber(345678901)
                .setWarnings(2)
                .build();
        Customer customer5 = new Customer.Builder()
                .setName("Charlie Brown")
                .setEmail("charlie.brown@example.com")
                .setPhoneNumber(456789012)
                .setWarnings(0)
                .build();

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);

        List<Customer> customers = customerRepository.findAll();
        assertThat(customers).hasSize(5).contains(customer1, customer2, customer3, customer4, customer5);
    }

    @Test
    public void testFindById() {
        Customer customer = new Customer.Builder()
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setPhoneNumber(123456789)
                .setWarnings(0)
                .build();

        Customer savedCustomer = customerRepository.save(customer);
        Customer foundCustomer = customerRepository.findById(savedCustomer.getId()).orElse(null);

        assertThat(foundCustomer).isNotNull();
        assertThat(foundCustomer.getName()).isEqualTo("John Doe");
    }

    @Test
    public void testDeleteById() {
        Customer customer = new Customer.Builder()
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setPhoneNumber(123456789)
                .setWarnings(0)
                .build();

        Customer savedCustomer = customerRepository.save(customer);
        customerRepository.deleteById(savedCustomer.getId());

        boolean exists = customerRepository.findById(savedCustomer.getId()).isPresent();
        assertThat(exists).isFalse();
    }
}
