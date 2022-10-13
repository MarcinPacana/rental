package pl.rentalcar.servlets.frontend.customer;

import pl.rentalcar.frontend.LoginController;
import pl.rentalcar.PageList;
import pl.rentalcar.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginController loginController;

    public LoginServlet() {
        this.loginController = new LoginController(new CustomerService());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PageList.LOGIN_PAGE).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loginController.login(req,resp);
    }
}
