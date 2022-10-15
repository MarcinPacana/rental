package pl.rentalcar.servlets.admin.user;

import pl.rentalcar.admin.AdminController;
import pl.rentalcar.admin.implement.AdminControllerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/")
public class AdminHomeServlet extends HttpServlet {

    AdminController adminController;

    public AdminHomeServlet() {
        this.adminController = new AdminControllerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AdminHomeServlet: doGet");
        adminController.showAdminHomePage(req,resp);
    }
}
