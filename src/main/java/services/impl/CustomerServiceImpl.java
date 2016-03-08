package services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CustomerRepository;
import repository.entity.Customer;

/**
 * Created by Veronika on 08.03.2016.
 */
@Service
@Transactional
public class CustomerServiceImpl {
    @Autowired
    private CustomerRepository customerRepository;
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer)
    {
        customerRepository.delete(customer);
    }

}
