package pl.rentalcar.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AdminController {
    public void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void logOutAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException;
    public void showLoginFormAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void showAdminHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
