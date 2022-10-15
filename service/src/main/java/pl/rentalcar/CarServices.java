package pl.rentalcar;

import pl.rentalcar.dao.CarDAO;
import pl.rentalcar.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CarServices {

    CarDAO carDAO;

    public CarServices() {
        this.carDAO = new CarDAO();
    }

    public List<Car> getAll() {
        return carDAO.getAll();
    }

    public void addCar(Car car) {
        carDAO.create(car);
    }

    public void deleteCar(int id){
        carDAO.delete(id);
    }

    public void updateCar(Car car) {
        carDAO.update(car);
    }

    public Car getById(int id) {
        return carDAO.get(id);
    }

    public Car createCarFromRequest(HttpServletRequest request) throws ServletException, IOException {
        Car car = new Car();
        readFieldsOfCar(request, car);
        readImageField(request, car);
        return car;
    }

    public void updateCarFields(HttpServletRequest req,Car car) throws ServletException, IOException {
        readFieldsOfCar(req, car);
        readImageField(req,car);
    }



    private void readFieldsOfCar(HttpServletRequest request, Car car) {
        car.setBrand(request.getParameter("brand"));
        car.setModel(request.getParameter("model"));
        car.setColor(request.getParameter("color"));
        car.setSeats(Integer.parseInt(request.getParameter("seats")));

        String airConditioning = (String) request.getParameter("airConditioning");
        if (airConditioning.equals("Tak")) {
            car.setAirConditioning(true);
        } else {
            car.setAirConditioning(false);
        }
        car.setTrunkSize(Integer.parseInt(request.getParameter("trunkSize")));
        car.setDors(Integer.parseInt(request.getParameter("dors")));
        car.setGearBox(request.getParameter("gearBox"));
        car.setEnginePower(Integer.parseInt(request.getParameter("enginePower")));
        car.setPrice(Float.parseFloat(request.getParameter("price")));


    }

    private void readImageField(HttpServletRequest request, Car car) throws IOException, ServletException {
        Part image = request.getPart("image");
        if (image != null && image.getSize() > 0) {
            long size = image.getSize();
            byte[] imageBytes = new byte[(int) size];
            InputStream inputStream = image.getInputStream();
            inputStream.read(imageBytes);
            inputStream.close();
            int length = imageBytes.length;
            car.setImage(imageBytes);
        }
    }
}
