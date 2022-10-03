package pl.rentalcar;

import pl.rentalcar.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController {


    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String email = req.getParameter("email");
        String password = GeneratorService.generateMD5(req.getParameter("password"));
        Customer customer = userService.loginUser(email, password);
        if (customer != null) {
            HttpSession session = req.getSession();
            session.setAttribute("loggedCustomer", customer);
            PageUtility.forwardToPage(req, resp, PageList.HOME_PAGE);
        } else {
            PageUtility.forwardToPage(req, resp, PageList.LOGIN_PAGE);
        }
    }

    public void logout() {

    }
}
