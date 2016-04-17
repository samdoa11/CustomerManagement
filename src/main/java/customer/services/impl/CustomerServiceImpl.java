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
        //to update customer with ID it was only neccesary to overwrite the equals method in customer.
        customerRepository.save(customer);
        return customer.getId();
    }

     @Override
    public void deleteCustomer(Customer customer)
    {
        customerRepository.delete(customer);
    }


    @Override
    public Customer getCustomerWithId(long custId) {
        return customerRepository.findOne(custId);
    }
}
