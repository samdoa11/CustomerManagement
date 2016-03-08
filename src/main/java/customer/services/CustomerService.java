package customer.services;

import org.springframework.stereotype.Service;
import customer.repository.entity.Customer;

public interface CustomerService {
    Iterable<Customer> getAllCustomers();
    Long saveCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
