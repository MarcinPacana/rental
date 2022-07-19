package pl.rentalcar.servlets;
import pl.rentalcar.SimpleClassService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/car_list")
public class CarListServlet extends HttpServlet {

    private final SimpleClassService simpleClassService;

    public CarListServlet() {
        this.simpleClassService = new SimpleClassService(2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = simpleClassService.count(5);
        System.out.println("Wynik operacji to: "+count);
        SimpleClassService.printData(req,"CarListServlet");

        req.getRequestDispatcher("car_list.jsp").forward(req,resp);
    }
}
