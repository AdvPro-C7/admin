package id.ac.ui.cs.advprog.admin.controller;

import id.ac.ui.cs.advprog.admin.model.Customer;
import id.ac.ui.cs.advprog.admin.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

        customer1 = new Customer.Builder()
                .setId(1)
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setPhoneNumber(123456789)
                .setWarnings(0)
                .build();

        customer2 = new Customer.Builder()
                .setId(2)
                .setName("Jane Doe")
                .setEmail("jane.doe@example.com")
                .setPhoneNumber(987654321)
                .setWarnings(1)
                .build();
    }

    @Test
    void testGetAllCustomers() {
        List<Customer> customers = Arrays.asList(customer1, customer2);
        when(customerService.getAllCustomers()).thenReturn(CompletableFuture.completedFuture(customers));

        CompletableFuture<ResponseEntity<List<Customer>>> responseEntityCompletableFuture = customerController.getAllCustomers();
        ResponseEntity<List<Customer>> responseEntity = responseEntityCompletableFuture.join();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(customers, responseEntity.getBody());
    }

    @Test
    void testGetCustomerById() {
        when(customerService.getCustomerById(1)).thenReturn(CompletableFuture.completedFuture(customer1));

        CompletableFuture<ResponseEntity<Customer>> responseEntityCompletableFuture = customerController.getCustomerById(1);
        ResponseEntity<Customer> responseEntity = responseEntityCompletableFuture.join();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(customer1, responseEntity.getBody());
    }

    @Test
    void testSaveOrUpdateCustomer() {
        when(customerService.saveOrUpdateCustomer(customer1)).thenReturn(CompletableFuture.completedFuture(customer1));

        CompletableFuture<ResponseEntity<Customer>> responseEntityCompletableFuture = customerController.saveOrUpdateCustomer(customer1);
        ResponseEntity<Customer> responseEntity = responseEntityCompletableFuture.join();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(customer1, responseEntity.getBody());
    }

    @Test
    void testDeleteCustomer() {
        when(customerService.deleteCustomer(1)).thenReturn(CompletableFuture.completedFuture(null));

        CompletableFuture<ResponseEntity<Void>> responseEntityCompletableFuture = customerController.deleteCustomer(1);
        ResponseEntity<Void> responseEntity = responseEntityCompletableFuture.join();

        assertEquals(204, responseEntity.getStatusCodeValue());
    }

}
