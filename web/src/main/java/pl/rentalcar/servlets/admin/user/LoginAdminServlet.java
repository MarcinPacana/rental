package pl.rentalcar.servlets.admin.user;

import pl.rentalcar.admin.AdminController;
import pl.rentalcar.admin.implement.AdminControllerImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/loginAdmin")
public class LoginAdminServlet extends HttpServlet {

    AdminController adminController;

    public LoginAdminServlet() {
        this.adminController = new AdminControllerImpl();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginAdminServlet: doPost");
        adminController.loginAdmin(req,resp);
    }
}
