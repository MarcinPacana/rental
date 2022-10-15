package pl.rentalcar.dao;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.rentalcar.entity.Customer;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CustomerDAOTest {

    public static CustomerDAO customerDAO;

    @BeforeClass
    public static void setUpClass() throws Exception {
        customerDAO = new CustomerDAO();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        customerDAO.close();
    }

    @Test
    public void createTest() {
        Customer customer = new Customer();
        customer.setFirstName("Marcin");
        customer.setLastName("Kowalski");
        customer.setEmail("marcin@kowalski.pl");
        customer.setPassword("bardzoSilneHaslo");

        customer.setCountry("Polska");
        customer.setCity("Warszawa");
        customer.setStreet("Na Kotline");
        customer.setFlatNumber("5");
        customer.setZipCode("12345");

        Customer customerAdded = customerDAO.create(customer);

        assertTrue(customerAdded.getId() >= 0);
    }

    public void testGet() {

    }

    public void testUpdate() {
    }

    public void testDelete() {
    }

    @Test
    public void testGetAll() {
        int size = customerDAO.getAll().size();
        assertTrue(size>0);
    }


    @Test
    public void testEmailExist() {
        boolean emailExist = customerDAO.emailExist("jannowak@kowalski.pl");
        assertTrue(emailExist);

        boolean notExists = customerDAO.emailExist("niematakiego@adresu.pl");
        assertTrue(!notExists);
    }
}

