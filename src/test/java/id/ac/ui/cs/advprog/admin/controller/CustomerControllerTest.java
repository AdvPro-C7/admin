package id.ac.ui.cs.advprog.admin.controller;

import id.ac.ui.cs.advprog.admin.model.Customer;
import id.ac.ui.cs.advprog.admin.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testGetAllCustomers() throws Exception {
        Customer customer1 = new Customer.Builder().setId(1).setName("John Doe").setEmail("john@example.com").build();
        Customer customer2 = new Customer.Builder().setId(2).setName("Jane Doe").setEmail("jane@example.com").build();
        List<Customer> customers = Arrays.asList(customer1, customer2);

        when(customerService.getAllCustomers()).thenReturn(CompletableFuture.completedFuture(customers));

        mockMvc.perform(get("/api/customer/"))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    ResponseEntity<List<Customer>> response = (ResponseEntity<List<Customer>>) result.getAsyncResult();
                    assertEquals(2, response.getBody().size());
                });
    }

    @Test
    void testGetCustomerById() throws Exception {
        Customer customer = new Customer.Builder().setId(1).setName("John Doe").setEmail("john@example.com").build();

        when(customerService.getCustomerById(1)).thenReturn(CompletableFuture.completedFuture(customer));

        mockMvc.perform(get("/api/customer/1"))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    ResponseEntity<Customer> response = (ResponseEntity<Customer>) result.getAsyncResult();
                    assertEquals("John Doe", response.getBody().getName());
                });
    }
}
