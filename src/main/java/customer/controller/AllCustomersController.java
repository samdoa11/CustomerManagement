package customer.controller;

import customer.repository.entity.Customer;
import customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Dominik on 01.03.2016.
 */
@RestController
public class AllCustomersController {


    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/customer", method= RequestMethod.POST)
    public ResponseEntity readAll(){
        return  ResponseEntity.ok(customerService.getAllCustomers());

    }


    @RequestMapping(value="/customer", method=RequestMethod.DELETE)
    public ResponseEntity deleteCustomer(@RequestBody Customer customer)
    {
        if (customer == null || customer.getUsername() == null || customer.getUsername()=="" ||
                customer.getLastname() == null || customer.getLastname() == "") {
            return ResponseEntity.noContent().build();
        }
        Iterable<Customer> ll= customerService.getAllCustomers();
        boolean found = false;
        for(Customer c:ll)
        {
            if(customer.getId().equals(c.getId()))
                found=true;

        }
        if(found==false)
        {
            return ResponseEntity.notFound().build();
        }
        else {
            customerService.deleteCustomer(customer);
            return ResponseEntity.ok(customer);
        }

    }

    @RequestMapping(value="/customer", method=RequestMethod.PUT)
    public ResponseEntity putCustomer(@RequestBody Customer customer) {
        if (customer == null || customer.getUsername() == null || customer.getUsername()=="" ||
                customer.getLastname() == null || customer.getLastname() == "") {
            return ResponseEntity.noContent().build();
        }
        long id = customerService.saveCustomer(customer);
        return ResponseEntity.ok(id);
    }

    @RequestMapping(value="/customer", method=RequestMethod.GET)
    public ResponseEntity getCustomers(@RequestParam("customerId") int custId) {
        if (custId < 0) return ResponseEntity.noContent().build();
        Customer customer = customerService.getCustomerWithId(custId);
        if (customer == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(customer);
    }


}
