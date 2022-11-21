package pl.rentalcar.servlets.frontend.car;

import pl.rentalcar.frontend.CarController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/car")
public class CarServlet extends HttpServlet {

    CarController carController;

    public CarServlet() {
        this.carController = new CarController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        carController.viewCar(req,resp);
    }
}
