package pl.rentalcar.servlets.admin.car;

import pl.rentalcar.admin.CarController;
import pl.rentalcar.admin.implement.CarControllerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/editCar")
public class EditCarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarController carController = new CarControllerImpl();
        carController.showEditCarForm(req,resp);
    }
}
