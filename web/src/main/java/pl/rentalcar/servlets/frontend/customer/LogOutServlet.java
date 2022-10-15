package pl.rentalcar.servlets.frontend.customer;

import pl.rentalcar.frontend.LoginController;
import pl.rentalcar.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {

    private LoginController loginController;

    public LogOutServlet() {
        this.loginController = new LoginController(new CustomerService());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loginController.logout(req,resp);


    }
}
