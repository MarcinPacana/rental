package pl.rentalcar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private LocalDateTime pickupDate;

    private LocalDateTime returnDate;

    private double amount;

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

}
