package id.ac.ui.cs.advprog.admin.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCustomerBuilder() {
        Customer customer1 = new Customer.Builder()
                .setId(1)
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setPhoneNumber(123456789)
                .setWarnings(0)
                .build();

        Customer customer2 = new Customer.Builder()
                .setId(2)
                .setName("Jane Doe")
                .setEmail("jane.doe@example.com")
                .setPhoneNumber(987654321)
                .setWarnings(1)
                .build();

        Customer customer3 = new Customer.Builder()
                .setId(3)
                .setName("Alice Smith")
                .setEmail("alice.smith@example.com")
                .setPhoneNumber(234567890)
                .setWarnings(0)
                .build();

        Customer customer4 = new Customer.Builder()
                .setId(4)
                .setName("Bob Johnson")
                .setEmail("bob.johnson@example.com")
                .setPhoneNumber(345678901)
                .setWarnings(2)
                .build();

        Customer customer5 = new Customer.Builder()
                .setId(5)
                .setName("Charlie Brown")
                .setEmail("charlie.brown@example.com")
                .setPhoneNumber(456789012)
                .setWarnings(0)
                .build();

        assertAll("Test All Customers",
                () -> assertEquals(1, customer1.getId()),
                () -> assertEquals("John Doe", customer1.getName()),
                () -> assertEquals("john.doe@example.com", customer1.getEmail()),
                () -> assertEquals(123456789, customer1.getPhoneNumber()),
                () -> assertEquals(0, customer1.getWarnings()),

                () -> assertEquals(2, customer2.getId()),
                () -> assertEquals("Jane Doe", customer2.getName()),
                () -> assertEquals("jane.doe@example.com", customer2.getEmail()),
                () -> assertEquals(987654321, customer2.getPhoneNumber()),
                () -> assertEquals(1, customer2.getWarnings()),

                () -> assertEquals(3, customer3.getId()),
                () -> assertEquals("Alice Smith", customer3.getName()),
                () -> assertEquals("alice.smith@example.com", customer3.getEmail()),
                () -> assertEquals(234567890, customer3.getPhoneNumber()),
                () -> assertEquals(0, customer3.getWarnings()),

                () -> assertEquals(4, customer4.getId()),
                () -> assertEquals("Bob Johnson", customer4.getName()),
                () -> assertEquals("bob.johnson@example.com", customer4.getEmail()),
                () -> assertEquals(345678901, customer4.getPhoneNumber()),
                () -> assertEquals(2, customer4.getWarnings()),

                () -> assertEquals(5, customer5.getId()),
                () -> assertEquals("Charlie Brown", customer5.getName()),
                () -> assertEquals("charlie.brown@example.com", customer5.getEmail()),
                () -> assertEquals(456789012, customer5.getPhoneNumber()),
                () -> assertEquals(0, customer5.getWarnings())
        );
    }
}
