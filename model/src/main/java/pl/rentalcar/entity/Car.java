package pl.rentalcar.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "car.getAll", query = "select c from Car c")
})


@Entity
public class Car {


    @Id
    @Column(name = "auto_id")
    private int id;

    private String brand;
    private String model;
    private String color;
    private int seats;
    private boolean airConditioning;
    private int trunkSize;
    private int dors;
    private String gearBox;
    private int enginePower;
    private byte[] image;
    private float price;

    @Transient
    private String imageBase64;

    @OneToMany
    private List<Reservation> carReservations = new ArrayList<>(0);



    @Transient
    public String getStringAirConditioning() {
        if (airConditioning) {
            return "TAK";
        } else {
            return "NIE";
        }
    }
}
