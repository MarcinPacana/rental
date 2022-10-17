package pl.rentalcar;

import junit.framework.TestCase;
import org.junit.Test;
import pl.rentalcar.entity.Customer;

public class ValidatorTest extends TestCase {

    private static Validator validator = new Validator();



    @Test
    public void testValidateCustomerCorrect() {
        Customer customer = new Customer();
        customer.setFirstName("Jan");
        customer.setLastName("Nowak");
        customer.setEmail("jan@nowak.pl");
        customer.setPassword("haslo123");

        boolean customerCorrect = validator.validateCustomerForAdd(customer);

        assertTrue(customerCorrect);
    }

    @Test
    public void testValidateCustomerEmailNotCorrect() {
        Customer customer = new Customer();
        customer.setFirstName("Jan");
        customer.setLastName("Nowak");
        customer.setEmail("jannowak.pl");
        customer.setPassword("haslo123");

        boolean customerCorrect = validator.validateCustomerForAdd(customer);

        assertFalse(customerCorrect);
    }

    @Test
    public void testValidateCustomerFirstNameIsNull() {
        Customer customer = new Customer();
        customer.setLastName("Nowak");
        customer.setEmail("jan@nowak.pl");
        customer.setPassword("haslo123");

        boolean customerCorrect = validator.validateCustomerForAdd(customer);

        assertFalse(customerCorrect);
    }

    @Test
    public void testValidateCustomerLastNameIsEmpty() {
        Customer customer = new Customer();
        customer.setFirstName("Jan");
        customer.setLastName("");
        customer.setEmail("jan@nowak.pl");
        customer.setPassword("haslo123");

        boolean customerCorrect = validator.validateCustomerForAdd(customer);

        assertFalse(customerCorrect);
    }
}