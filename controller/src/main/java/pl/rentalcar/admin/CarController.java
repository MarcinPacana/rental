package pl.rentalcar.admin;

import pl.rentalcar.PageUtility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface CarController {

    public void showAllCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void showNewCarForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void showEditCarForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void createNewCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    void updateCar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void deleteCar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException;
}
