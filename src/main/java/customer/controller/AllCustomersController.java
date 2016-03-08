package customer.controller;

import customer.repository.entity.Customer;
import customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dominik on 01.03.2016.
 */
@RestController
public class AllCustomersController {


    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/customer", method= RequestMethod.POST)
    public Iterable<Customer> readAll(){

        return  customerService.getAllCustomers();

    }


    @RequestMapping(value="/customer", method=RequestMethod.DELETE)
    public void deleteCustomer(@RequestBody Customer customer)
    {
        customerService.deleteCustomer(customer);
    }

    @RequestMapping(value="/customer", method=RequestMethod.PUT)
    public Long readCustomer(@RequestBody Customer c)
    {
        customerService.updateCustomer(c);
        return c.getId();
    }

    public Long putCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }


}
