package customer.services.impl;

import customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import customer.repository.CustomerRepository;
import customer.repository.entity.Customer;

/**
 * Created by Veronika on 08.03.2016.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Long saveCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer.getId();
    }

     @Override
    public void deleteCustomer(Customer customer)
    {
        customerRepository.delete(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.delete(customer.getId());
        customerRepository.save(customer);
    }
}
