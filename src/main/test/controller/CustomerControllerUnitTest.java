package controller;

import customer.Application;
import customer.controller.AllCustomersController;
import customer.repository.entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("dev")
public class CustomerControllerUnitTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private AllCustomersController productController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void testFindAllCustomersWithoutExtention() throws Exception {
        this.mockMvc.perform(post("/customer"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].lastname").exists())
                .andExpect(jsonPath("$[1].lastname").exists());
    }

    @Test
    public void testPutCustomerWithoutExtention() throws Exception {
        Customer customer = new Customer();
        customer.setBirthdate(new Date(2010, 01,01));
        customer.setFistname("Vroni");
        customer.setLastname("Geo");
        customer.setOrt("sdf");
        customer.setPassword("sdf");
        customer.setPlz(11111);
        customer.setStrasse("sdf");
        customer.setUsername("vroni");

        this.mockMvc.perform(put("/customer", customer))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0]").exists());
    }

}
