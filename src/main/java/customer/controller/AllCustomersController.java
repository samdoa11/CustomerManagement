package customer.controller;

import customer.repository.entity.Customer;
import customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Dominik on 01.03.2016.
 */
@Controller
public class AllCustomersController {




    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/customer", method= RequestMethod.POST)
    public Iterable<Customer> readAll(){

        return  customerService.getAllCustomers();

    }



    @RequestMapping(value="/customer", method=RequestMethod.DELETE)
    public void readCustomer(@RequestBody Customer customer)
    {
        customerService.deleteCustomer(customer);
    }


}
