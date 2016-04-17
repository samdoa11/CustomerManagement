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
       Customer customer = CustomerBuilder.createCustomer1();
        customerRepository.save(customer);

        customer = CustomerBuilder.createCustomer2();
        customerRepository.save(customer);
    }
}
