package pl.rentalcar.frontend;

import pl.rentalcar.MessageService;
import pl.rentalcar.PageList;
import pl.rentalcar.PageUtility;
import pl.rentalcar.UserService;
import pl.rentalcar.entity.Customer;
import pl.rentalcar.GeneratorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class RegistrationController {

    UserService<Customer> userService;
    MessageService messageService;

    public RegistrationController(UserService<Customer> userService) {
        this.userService = userService;
        this.messageService = new MessageService();
    }

    public void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        boolean emailExist = userService.isEmailExist(email);
        if (emailExist){
            messageService.setEmailExist(request);
            PageUtility.forwardToPage(request,response, PageList.REGISTER_PAGE);
        }else {
            Customer customer = getCustomerFromRequest(request, email);
            setOtherParam(customer);
            userService.add(customer);
            response.sendRedirect("login");
        }
    }

    private Customer setOtherParam(Customer customer){
        customer.setActive(true);
        customer.setRegisteredDate(LocalDate.now());
        return customer;
    }

    private Customer getCustomerFromRequest(HttpServletRequest request, String email) {
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPhoneNumber(Integer.parseInt(request.getParameter("phoneNumber")));
        customer.setFirstName(request.getParameter("firstName"));
        customer.setLastName(request.getParameter("lastName"));
        String password = GeneratorService.generateMD5(request.getParameter("password"));
        customer.setPassword(password);

        customer.setCountry(request.getParameter("country"));
        customer.setCity(request.getParameter("city"));
        customer.setStreet(request.getParameter("streat"));
        customer.setFlatNumber(request.getParameter("flatNumber"));
        customer.setZipCode(request.getParameter("zipCode"));

        return customer;
    }
}
