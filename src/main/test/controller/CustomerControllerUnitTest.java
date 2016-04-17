package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import customer.Application;
import customer.controller.AllCustomersController;
import customer.repository.entity.Customer;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import java.text.DateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
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
    public void testPutCustomerWithCorrectCustomer() throws Exception {
        Customer customer = createDummyCustomer();
        JSONObject obj = createJsonWithCustomer(customer);
        String json = obj.toJSONString();
        MvcResult result = this.mockMvc.perform(put("/customer").contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();
        Assert.assertThat(result.getResponse().getContentAsString(),equalTo("10") );
    }

    @Test
    public void testPutCustomerNoContent() throws Exception {
        Customer customer = createDummyCustomer();
        customer.setUsername("");
        JSONObject obj = createJsonWithCustomer(customer);
        String json = obj.toJSONString();
        this.mockMvc.perform(put("/customer").contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testGetCustomerThatExists() throws Exception {
        this.mockMvc.perform(get("/customer?customerId=1")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.id").exists()).andExpect(jsonPath("$.firstname").exists())
                .andExpect(jsonPath("$.lastname").exists()).andExpect(jsonPath("$.username").exists())
                .andExpect(jsonPath("$.strasse").exists()).andExpect(jsonPath("$.plz").exists());
    }

    @Test
    public void testGetCustomerWithNotFound() throws Exception {
        this.mockMvc.perform(get("/customer?customerId=100")).andExpect(status().isNotFound());
    }

    @Test
    public void testGetCustomerWithNoContent() throws Exception {
        this.mockMvc.perform(get("/customer?customerId=-1")).andExpect(status().isNoContent());
    }


    private JSONObject createJsonWithCustomer(Customer customer) {
        JSONObject obj = new JSONObject();
        obj.put("id", 10);
        obj.put("firstname", customer.getFirstname());
        obj.put("lastname", customer.getLastname());
        obj.put("username", customer.getUsername());
        obj.put("strasse", customer.getStrasse());
        obj.put("plz", customer.getPlz());
        obj.put("ort", customer.getOrt());
        obj.put("birthdate", customer.getBirthdate().getTime());
        obj.put("password", customer.getPassword());
        return obj;
    }

    private Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setBirthdate(new Date(2010, 01,01));
        customer.setFirstname("Vroni");
        customer.setLastname("Geo");
        customer.setOrt("sdf");
        customer.setPassword("sdf");
        customer.setPlz(11111);
        customer.setStrasse("sdf");
        customer.setUsername("vroni");
        return customer;
    }

}
