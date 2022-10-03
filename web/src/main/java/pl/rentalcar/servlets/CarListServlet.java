package pl.rentalcar.servlets;
import pl.rentalcar.PrinterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/car_list")
public class CarListServlet extends HttpServlet {

    public CarListServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrinterService.printData(req,"CarListServlet");
        req.getRequestDispatcher("car_list.jsp").forward(req,resp);
    }
}
