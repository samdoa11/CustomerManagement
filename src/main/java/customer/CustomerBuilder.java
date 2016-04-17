package customer;

import customer.repository.entity.Customer;
import net.minidev.json.JSONObject;

import java.util.Date;

/**
 * Created by Dominik on 17.04.2016.
 */
public class CustomerBuilder {

    public static Customer createCustomer1() {
        Customer customer = new Customer();
        customer.setBirthdate(new Date(2010, 01,01));
        customer.setId(1L);
        customer.setFirstname("Domi");
        customer.setLastname("Sammer");
        customer.setOrt("Leibnitz");
        customer.setPassword("1234");
        customer.setPlz(8430);
        customer.setStrasse("Dorfstrasse");
        customer.setUsername("da_domi");
        return customer;
    }

    public static Customer createCustomer2() {
        Customer customer = new Customer();
        customer.setId(2L);
        customer.setBirthdate(new Date(2010, 01,01));
        customer.setFirstname("sdf");
        customer.setLastname("sdf");
        customer.setOrt("asdf");
        customer.setPassword("2234");
        customer.setPlz(2222);
        customer.setStrasse("Dorsdfstrasse");
        customer.setUsername("aaaaaa");
        return customer;
    }

    public static Customer createDummyCustomer() {
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
