package id.ac.ui.cs.advprog.admin.controller;

import id.ac.ui.cs.advprog.admin.model.Customer;
import id.ac.ui.cs.advprog.admin.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    void setUp() {
        customer1 = new Customer(1, "Customer 1", "email1@example.com", 123456, 0);
        customer2 = new Customer(2, "Customer 2", "email2@example.com", 654321, 0);
    }

    @Test
    void testGetAllCustomers() throws Exception {
        List<Customer> customerList = Arrays.asList(customer1, customer2);

        when(customerService.getAllCustomers()).thenReturn(CompletableFuture.completedFuture(customerList));

        mockMvc.perform(get("/api/customer/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Customer 1")))
                .andExpect(jsonPath("$[1].name", is("Customer 2")));
    }

    @Test
    void testGetCustomerById() throws Exception {
        when(customerService.getCustomerById(1)).thenReturn(CompletableFuture.completedFuture(customer1));

        mockMvc.perform(get("/api/customer/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Customer 1")));
    }

    @Test
    void testSaveOrUpdateCustomer() throws Exception {
        when(customerService.saveOrUpdateCustomer(any(Customer.class))).thenReturn(CompletableFuture.completedFuture(customer1));

        mockMvc.perform(post("/api/customer/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"id\": 1, \"name\": \"Customer 1\", \"email\": \"email1@example.com\", \"phoneNumber\": 123456, \"warnings\": 0 }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Customer 1")));
    }

    @Test
    void testDeleteCustomer() throws Exception {
        when(customerService.deleteCustomer(1)).thenReturn(CompletableFuture.completedFuture(null));

        mockMvc.perform(delete("/api/customer/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void testWarnCustomer() throws Exception {
        Customer warnedCustomer = new Customer(1, "Customer 1", "email1@example.com", 123456, 1);

        when(customerService.getCustomerById(1)).thenReturn(CompletableFuture.completedFuture(customer1));
        when(customerService.saveOrUpdateCustomer(any(Customer.class))).thenReturn(CompletableFuture.completedFuture(warnedCustomer));

        mockMvc.perform(post("/api/customer/warn/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.warnings", is(1)));
    }
}
