package controller;

import customer.repository.entity.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerControllerIntegrationTest extends AbstractControllerIntegrationTest {

    @Value("${local.server.port}")
    private int port;

    private RestTemplate restTemplate;

    @Before
    public void setup() {
        this.restTemplate = new TestRestTemplate();
        this.restTemplate.setMessageConverters(configureMessageConverters());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testGetCustomer() throws Exception {
        String url = String.format("http://localhost:%s/customer?customerId=1", port);
        Customer customer = (Customer) restTemplate.getForObject(url, Customer.class);

        Assert.assertEquals(customer.getLastname(), "Sammer");
    }

    @Test
    public void testGetAllCustomers() throws Exception {
        String url = String.format("http://localhost:%s/customer?customerId=1", port);
        List<Customer> customers = (List<Customer>) restTemplate.postForObject(url, null, List.class);
        Assert.assertEquals(customers.size(), 2);
    }

    @Test
    public void testPutNewCustomer() throws Exception {
        String url = String.format("http://localhost:%s/customer", port);
        Customer newCustomer = new Customer();

    }
}
