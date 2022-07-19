package pl.rentalcar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean status;

}