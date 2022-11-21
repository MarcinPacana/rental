package pl.rentalcar.frontend;

import pl.rentalcar.CarServices;
import pl.rentalcar.PageList;
import pl.rentalcar.PageUtility;
import pl.rentalcar.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CarController {


    public void showAllCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarServices carServices = new CarServices();
        List<Car> carList = carServices.getAll();

        request.setAttribute("carList",carList);
        PageUtility.forwardToPage(request,response,PageList.CAR_LIST_PAGE);

    }

    public void viewCar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarServices carServices = new CarServices();

        int id = Integer.parseInt(req.getParameter("id"));
        Car carById = carServices.getById(id);

        req.setAttribute("car",carById);
        PageUtility.forwardToPage(req,resp,PageList.FRONTEND_CAR_DETAIL);
    }
}
