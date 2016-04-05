package controller;

import customer.Application;
import customer.controller.AllCustomersController;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("dev")
public class ProductControllerUnitTest {

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
    public void testFindAllProductsWithDefaultExtension() throws Exception {
        this.mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].name").exists())
                .andExpect(jsonPath("$[1].name").exists())
                .andExpect(jsonPath("$[2].name").exists());
    }

    @Test
    public void testFindAllProductsWithXmlExtension() throws Exception {
        this.mockMvc.perform(get("/products.xml"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML))
                .andExpect(xpath("//product[1]").exists())
                .andExpect(xpath("//product[2]").exists())
                .andExpect(xpath("//product[3]").exists());
    }

    @Test
    public void testFindAllProductsWithJsonExtension() throws Exception {
        this.mockMvc.perform(get("/products.json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].name").exists())
                .andExpect(jsonPath("$[1].name").exists())
                .andExpect(jsonPath("$[2].name").exists());
    }


    @Test
    public void testFindAllProductsWithTxtExtension() throws Exception {
        this.mockMvc.perform(get("/products.txt"))
                .andExpect(status().isNotAcceptable());
    }

}
