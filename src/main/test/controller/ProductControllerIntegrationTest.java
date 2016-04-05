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
public class ProductControllerIntegrationTest extends AbstractControllerIntegrationTest {

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
    public void testFindAllProducts() throws Exception {
        String url = String.format("http://localhost:%s/products", port);
        List<Customer> products = (List<Customer>) restTemplate.getForObject(url, List.class);

        Assert.assertEquals(0, products.size());
    }
}
