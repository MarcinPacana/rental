package pl.rentalcar.frontend;

import pl.rentalcar.PageList;
import pl.rentalcar.PageUtility;
import pl.rentalcar.entity.Customer;
import pl.rentalcar.GeneratorService;
import pl.rentalcar.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController {

    CustomerService userService;

    public LoginController(CustomerService customerService) {
        this.userService = customerService;
    }

    public void login(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = GeneratorService.generateMD5(req.getParameter("password"));
        Customer customer = userService.login(email, password);

        if (customer == null) {
            PageUtility.forwardToPage(req, resp, PageList.LOGIN_PAGE);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("loggedCustomer", customer);
            Object objRedirectURL = session.getAttribute("redirectURL");
            if (objRedirectURL != null){
                String redirectURL = (String) objRedirectURL;
                session.removeAttribute("redirectURL");
                resp.sendRedirect(redirectURL);
            }else {
                PageUtility.forwardToPage(req, resp, PageList.PROFILE_PAGE);
            }
        }
    }

    public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("loggedCustomer");
        PageUtility.sendRedirect(request,response,request.getContextPath());
    }
}
