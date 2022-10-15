package pl.rentalcar.servlets.admin.car;

import pl.rentalcar.admin.CarController;
import pl.rentalcar.admin.implement.CarControllerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/createCar")
@MultipartConfig(
        fileSizeThreshold = 1024*10,  //10KB
        maxFileSize = 1024*500,  // 500KB
        maxRequestSize =  1024*1024 //1MB
)
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarController carController = new CarControllerImpl();
        carController.createNewCar(req,resp);
    }
}
