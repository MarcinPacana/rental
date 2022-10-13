package pl.rentalcar.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Customer.getAllCustomer", query = "SELECT c FROM Customer c"),
        @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email"),
        @NamedQuery(name = "Customer.checkLogin", query = "SELECT c FROM Customer c WHERE c.email = :email and c.password = :password")
})
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "klient_id", unique = true,nullable = false)
    private int id;

    @Column(name = "imie")
    private String firstName;

    @Column(name = "nazwisko")
    private String lastName;

    private String email;

    @Column(name = "numer_telefonu")
    private int phoneNumber;

    @Column(name = "haslo")
    private String password;

    @Column(name = "data_rejestracji")
    private LocalDate registeredDate;

    @Column(name = "kraj")
    private String country;

    @Column(name = "miasto")
    private String city;

    @Column(name = "ulica")
    private String street;

    @Column(name = "numer_mieszkania")
    private String flatNumber;

    @Column(name = "kod_pocztowy")
    private String zipCode;

    @Column(name = "token")
    private String token;

    @Column(name = "urzytkownik_aktywny", nullable = false)
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer")
    private Set<Reservation> reservationSet = new HashSet<>(0);


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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Reservation> getReservationSet() {
        return reservationSet;
    }

    public void setReservationSet(Set<Reservation> reservationSet) {
        this.reservationSet = reservationSet;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getId() == customer.getId() && isActive() == customer.isActive() && getFirstName().equals(customer.getFirstName()) && getLastName().equals(customer.getLastName()) && getEmail().equals(customer.getEmail()) && getPassword().equals(customer.getPassword()) && Objects.equals(getRegisteredDate(), customer.getRegisteredDate()) && Objects.equals(getCountry(), customer.getCountry()) && Objects.equals(getCity(), customer.getCity()) && Objects.equals(getStreet(), customer.getStreet()) && Objects.equals(getFlatNumber(), customer.getFlatNumber()) && Objects.equals(getZipCode(), customer.getZipCode()) && Objects.equals(getToken(), customer.getToken()) && Objects.equals(getReservationSet(), customer.getReservationSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getPassword(), getRegisteredDate(), getCountry(), getCity(), getStreet(), getFlatNumber(), getZipCode(), getToken(), isActive());
    }
}
