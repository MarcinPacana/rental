package pl.rentalcar.frontend;

import pl.rentalcar.PageList;
import pl.rentalcar.PageUtility;
import pl.rentalcar.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerController {


   CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
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
