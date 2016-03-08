package services;

import repository.entity.Customer;

/**
 * Created by Dominik on 01.03.2016.
 */
public interface CustomerService {
    Iterable<Customer> getAllCustomers();
    void saveCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
