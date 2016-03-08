package customer.controller;

import customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by Dominik on 01.03.2016.
 */
@Controller
public class AllCustomersController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/Customers")
    public String index(Model model){
        //model.addAttribute("customers",customerService.getAllCustomers());
        return "CustomerConfiguration";

    }

}
