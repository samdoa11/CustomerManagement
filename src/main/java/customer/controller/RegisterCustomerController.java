package customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import customer.repository.entity.Customer;

/**
 * Created by Dominik on 08.03.2016.
 */
@RestController
@RequestMapping("/customer/register")
public class RegisterCustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.PUT, value = "/customer")
    public Long putCutomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

}
