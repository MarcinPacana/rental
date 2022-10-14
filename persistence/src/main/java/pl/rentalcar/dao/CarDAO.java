package pl.rentalcar.dao;

import pl.rentalcar.entity.Car;

import java.util.List;

public class CarDAO extends JpaDAO<Car> implements GenericCRUD<Car>{


    @Override
    public Car create(Car car) {
        return super.create(car);
    }

    @Override
    public Car get(int id) {
        return super.find(Car.class,id);
    }

    @Override
    public Car update(Car car) {
        return super.update(car);
    }

    @Override
    public void delete(int id) {
        super.delete(Car.class, id);
    }

    @Override
    public List<Car> getAll() {
        List<Car> list = super.findWithNameQuery("car.getAll");
        int size = list.size();
        System.out.println("Size of listCar: "+size);
        for (Car c:list) {
            System.out.println(c.toString());
        }
        return list;
    }
}
