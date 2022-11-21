package pl.rentalcar.admin.implement;

import pl.rentalcar.CarServices;
import pl.rentalcar.PageList;
import pl.rentalcar.PageUtility;
import pl.rentalcar.Validator;
import pl.rentalcar.admin.CarController;
import pl.rentalcar.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CarControllerImpl implements CarController {

    CarServices carServices;
    Validator validator;

    public CarControllerImpl() {
        this.carServices = new CarServices();
        this.validator = new Validator();
    }

    @Override
    public void showAllCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> carList = carServices.getAll();
        request.setAttribute("carList",carList);

        List<Car> carList1 =(List<Car>) request.getAttribute("carList");
        for (Car c:carList1) {
            System.out.println(c.toString());
        }

        PageUtility.forwardToPage(request,response, PageList.ADMIN_LIST_CAR);
    }

    @Override
    public void showNewCarForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageUtility.forwardToPage(request,response,PageList.ADMIN_ADD_CAR_FORM);
    }

    @Override
    public void showEditCarForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        Car carById = carServices.getById(id);
        request.setAttribute("car",carById);

        PageUtility.forwardToPage(request,response,PageList.ADMIN_EDIT_CAR_FORM);
    }

    @Override
    public void createNewCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean requiredField= validator.isAllRequiredFieldNotEmptyForCar(request);
        if (requiredField){
            Car car = carServices.createCarFromRequest(request);
            carServices.addCar(car);
        }

        PageUtility.sendRedirect(request,response,request.getContextPath()+"/admin/listCar");
    }

    @Override
    public void updateCar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean requiredFields = validator.isAllRequiredFieldNotEmptyForCar(req);
        if (requiredFields){
            Car car = carServices.getById(Integer.parseInt(req.getParameter("id")));
            carServices.updateCarFields(req,car);
            carServices.updateCar(car);
        }
        showAllCars(req,resp);
    }

    @Override
    public void deleteCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        carServices.deleteCar(id);
        showAllCars(request,response);
    }
}
