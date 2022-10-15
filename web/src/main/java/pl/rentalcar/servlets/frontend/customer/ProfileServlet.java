package pl.rentalcar.servlets.frontend.customer;

import pl.rentalcar.frontend.CustomerController;
import pl.rentalcar.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private final CustomerController customerController;

    public ProfileServlet() {
        this.customerController = new CustomerController(new CustomerService());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        customerController.showCustomerProfile(req,resp);
    }
}
