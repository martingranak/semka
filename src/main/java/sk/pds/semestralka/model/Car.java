package sk.pds.semestralka.model;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

public class Car {
    private Long carId;
    private String name;
    private String type;
    private String fuel;
    private double consumption;
    private byte[] picture;
    private int pictureId;

    public Car() {
    }

    public Car(String name, String type, String fuel, double consumption, byte[] picture) {
        this.name = name;
        this.type = type;
        this.fuel = fuel;
        this.consumption = consumption;
        this.picture = picture;
    }

    public Car(String name, String type, String fuel, double consumption, int pictureId) {
        this.name = name;
        this.type = type;
        this.fuel = fuel;
        this.consumption = consumption;
        this.pictureId = pictureId;
    }

    public Long getId() {
        return carId;
    }

    public void setId(Long carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Double.compare(car.getConsumption(), getConsumption()) == 0 &&
                getId().equals(car.getId()) &&
                getName().equals(car.getName()) &&
                getType().equals(car.getType()) &&
                getFuel().equals(car.getFuel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getType(), getFuel(), getConsumption());
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + carId + ", name=" + name + ", type=" + type + ", fuel=" + fuel + ", consumption=" + consumption + '}';
    }
}
