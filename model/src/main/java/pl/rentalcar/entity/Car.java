package pl.rentalcar.entity;

import javax.persistence.*;
import java.util.*;

@NamedQueries({
        @NamedQuery(name = "car.getAll", query = "select c from Car c")
})
@Entity
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_id",unique = true,nullable = false)
    private int id;

    @Column(name = "marka",nullable = true)
    private String brand;

    @Column(name = "model",nullable = true)
    private String model;

    @Column(name = "kolor",nullable = true)
    private String color;

    @Column(name = "liczba_miejsc",nullable = true)
    private int seats;

    @Column(name = "klimatyzacja",nullable = true,columnDefinition = "boolean default false")
    private Boolean airConditioning;

    @Column(name = "wielkosc_bagaznika",nullable = true)
    private int trunkSize;

    @Column(name = "drzwi",nullable = true)
    private int dors;

    @Column(name = "skrzynia_biegow",nullable = true)
    private String gearBox;

    @Column(name = "moc_silnika",nullable = true)
    private int enginePower;

    @Column(name = "cena_podstawowa",nullable = true)
    private float price;

    @Column(name = "zdjecie")
    private byte[] image ;


    @Transient
    private String imageBase64;
/*
    @OneToMany
    private List<Reservation> carReservations = new ArrayList<>(0);
*/


    @Transient
    public String getStringAirConditioning() {
        if (airConditioning) {
            return "TAK";
        } else {
            return "NIE";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getTrunkSize() {
        return trunkSize;
    }

    public void setTrunkSize(int trunkSize) {
        this.trunkSize = trunkSize;
    }

    public int getDors() {
        return dors;
    }

    public void setDors(int dors) {
        this.dors = dors;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public String getImageBase64() {
        this.imageBase64 = Base64.getEncoder().encodeToString(this.image);
        return this.imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
/*

    public List<Reservation> getCarReservations() {
        return carReservations;
    }

    public void setCarReservations(List<Reservation> carReservations) {
        this.carReservations = carReservations;
    }
     */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getId() == car.getId() && getSeats() == car.getSeats() && getTrunkSize() == car.getTrunkSize() && getDors() == car.getDors() && getEnginePower() == car.getEnginePower() && Float.compare(car.getPrice(), getPrice()) == 0 && Objects.equals(getBrand(), car.getBrand()) && Objects.equals(getModel(), car.getModel()) && Objects.equals(getColor(), car.getColor()) && Objects.equals(isAirConditioning(), car.isAirConditioning()) && Objects.equals(getGearBox(), car.getGearBox()) && Arrays.equals(getImage(), car.getImage());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getBrand(), getModel(), getColor(), getSeats(), isAirConditioning(), getTrunkSize(), getDors(), getGearBox(), getEnginePower(), getPrice());
        result = 31 * result + Arrays.hashCode(getImage());
        return result;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", seats=" + seats +
                ", airConditioning=" + airConditioning +
                ", trunkSize=" + trunkSize +
                ", dors=" + dors +
                ", gearBox='" + gearBox + '\'' +
                ", enginePower=" + enginePower +
                ", price=" + price +
                '}';
    }
}
