package sk.pds.semestralka.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "RIDE")
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long driverId;
    private long carId;

    public Ride() {
    }

    public Ride(long driverId, long carId) {
        this.driverId = driverId;
        this.carId = carId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ride)) return false;
        Ride ride = (Ride) o;
        return getId() == ride.getId() &&
                getDriverId() == ride.getDriverId() &&
                getCarId() == ride.getCarId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDriverId(), getCarId());
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", driverId=" + driverId +
                ", carId=" + carId +
                '}';
    }
}
