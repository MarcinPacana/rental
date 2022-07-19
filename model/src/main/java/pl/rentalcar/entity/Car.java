package pl.rentalcar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
@NamedQuery(name = "car.getAll",query = "select c from Car c")
})


@Entity
public class Car {

    @Id
    private int id;
    private String brand;
    private String model;
    private String color;

}
