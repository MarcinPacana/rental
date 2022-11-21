package pl.rentalcar.servlets.admin.finanse;

import pl.rentalcar.admin.FinanseController;
import pl.rentalcar.admin.implement.ManageFinanceController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/finanse")
public class FinanseHomeServlet extends HttpServlet {

    FinanseController finanseController;

    public FinanseHomeServlet() {
        this.finanseController = new ManageFinanceController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        finanseController.showFinanseHomePage(req,resp);
    }
}
