package customer.services;

import customer.repository.entity.Customer;

public interface CustomerService {
    Iterable<Customer> getAllCustomers();
    Long saveCustomer(Customer customer);
    void deleteCustomer(Customer customer);

    void updateCustomer(Customer c);
}
