package pl.rentalcar.servlets.frontend.customer;

import pl.rentalcar.PageList;
import pl.rentalcar.frontend.RegistrationController;
import pl.rentalcar.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    RegistrationController registrationController;

    public RegisterServlet() {
        this.registrationController = new RegistrationController(new CustomerService());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PageList.REGISTER_PAGE).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        registrationController.registerUser(req,resp);
    }
}
