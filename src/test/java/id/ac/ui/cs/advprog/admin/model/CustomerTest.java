package id.ac.ui.cs.advprog.admin.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerTest {

    @Test
    void testCustomerBuilder() {
        Customer customer = new Customer.Builder()
                .setId(1)
                .setName("John Doe")
                .setEmail("john@example.com")
                .setPhoneNumber(123456789)
                .setWarnings(0)
                .build();

        assertNotNull(customer);
        assertEquals(1, customer.getId());
        assertEquals("John Doe", customer.getName());
        assertEquals("john@example.com", customer.getEmail());
        assertEquals(123456789, customer.getPhoneNumber());
        assertEquals(0, customer.getWarnings());
    }
}
