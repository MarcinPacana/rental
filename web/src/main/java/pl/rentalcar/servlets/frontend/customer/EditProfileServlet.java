package pl.rentalcar.servlets.frontend.customer;

import pl.rentalcar.frontend.CustomerController;
import pl.rentalcar.PageList;
import pl.rentalcar.PageUtility;
import pl.rentalcar.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class EditProfileServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageUtility.forwardToPage(req,resp,PageList.EDIT_PROFILE_PAGE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerController customerController = new CustomerController(new CustomerService());
        customerController.updateCustomerProfile(req,resp);
    }
}
