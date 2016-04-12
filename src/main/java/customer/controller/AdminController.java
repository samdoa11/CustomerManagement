package customer.controller;

import customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Dominik on 12.04.2016.
 */
@Controller
@RequestMapping("customer")
public class AdminController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String getAdminPage(Model m) {
        m.addAttribute("customers", customerService.getAllCustomers());
        return "admin_customers";
    }
}
