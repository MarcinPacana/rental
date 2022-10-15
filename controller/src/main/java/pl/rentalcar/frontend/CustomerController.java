package pl.rentalcar.frontend;

import pl.rentalcar.PageList;
import pl.rentalcar.PageUtility;
import pl.rentalcar.UserService;
import pl.rentalcar.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerController {


    UserService<Customer> userService;

    public CustomerController(UserService<Customer> userService) {
        this.userService = userService;
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
