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
        return super.findWithNameQuery("car.getAll");
    }
}
