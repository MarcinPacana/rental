package pl.rentalcar.frontend;

import pl.rentalcar.*;
import pl.rentalcar.entity.Customer;
import pl.rentalcar.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerController {

    public static final String EMAIL_EXIST = "Podany adres email istnieje juz w naszej bazie danych";

   CustomerService customerService;
   MessageService messageService;
   Validator validator;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
        this.messageService = new MessageService();
        this.validator = new Validator();
    }

    public void registerCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        boolean incorrectMail = validator.checkMail(email);
        boolean emailExist = customerService.isEmailExist(email);
        if (!incorrectMail || emailExist){
            messageService.setMessage(request,EMAIL_EXIST, MsgType.WARNING);
            PageUtility.forwardToPage(request,response, PageList.REGISTER_PAGE);
        }else {
            Customer customer = customerService.createCustomerFromRequest(request);
            customerService.add(customer);
            response.sendRedirect("login");
        }
    }

    public void showCustomerProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageUtility.forwardToPage(req, resp, PageList.PROFILE_PAGE);
    }

    public void editCustomerProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageUtility.forwardToPage(request,response,PageList.EDIT_PROFILE_PAGE);
    }


    public void updateCustomerProfile(HttpServletRequest req, HttpServletResponse resp) {


    }
}
