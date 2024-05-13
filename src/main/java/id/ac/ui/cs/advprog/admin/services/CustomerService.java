package id.ac.ui.cs.advprog.admin.services;
import id.ac.ui.cs.advprog.admin.model.Customer;

import java.util.List;


public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    Customer saveOrUpdateCustomer(Customer customer);
    void deleteCustomer(int id);
}