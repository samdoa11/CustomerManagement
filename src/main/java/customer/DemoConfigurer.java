package customer;

import customer.repository.CustomerRepository;
import customer.repository.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class DemoConfigurer {

    @Autowired
    private CustomerRepository customerRepository;

    @PostConstruct
    public void createDemoData() {
       Customer customer = new Customer();
        customer.setBirthdate(new Date(2010, 01,01));
        customer.setFistname("Domi");
        customer.setLastname("Sammer");
        customer.setOrt("Leibnitz");
        customer.setPassword("1234");
        customer.setPlz(8430);
        customer.setStrasse("Dorfstrasse");
        customer.setUsername("da_domi");
        customerRepository.save(customer);

        customer = new Customer();
        customer.setBirthdate(new Date(2010, 01,01));
        customer.setFistname("sdf");
        customer.setLastname("sdf");
        customer.setOrt("asdf");
        customer.setPassword("2234");
        customer.setPlz(2222);
        customer.setStrasse("Dorsdfstrasse");
        customer.setUsername("aaaaaa");
        customerRepository.save(customer);
    }
}
