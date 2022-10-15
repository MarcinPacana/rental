package pl.rentalcar.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.checkLogin",query = "select u from User u where u.password = :password and u.email = :email")
}

)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "urzytkownik_id", unique = true, nullable = false)
    private int id;

    @Column(name = "imie")
    private String firstName;

    @Column(name = "nazwisko")
    private String lastName;

    private String email;

    @Column(name = "haslo")
    private String password;

    @Column(name = "data_zatrudnienia")
    private LocalDate dateOfEmploment;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfEmploment() {
        return dateOfEmploment;
    }

    public void setDateOfEmploment(LocalDate dateOfEmploment) {
        this.dateOfEmploment = dateOfEmploment;
    }
}
