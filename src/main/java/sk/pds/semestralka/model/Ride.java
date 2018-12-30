package sk.pds.semestralka.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "RIDE")
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long rideId;
    private long carId;
    private String identityNumber;
    private LocalDateTime datetimeFrom;
    private LocalDateTime datetimeTo;

    public Ride() {
    }

    public Ride(long carId, String identityNumber, LocalDateTime datetimeFrom, LocalDateTime datetimeTo) {
        this.carId = carId;
        this.identityNumber = identityNumber;
        this.datetimeFrom = datetimeFrom;
        this.datetimeTo = datetimeTo;
    }

    public long getId() {
        return rideId;
    }

    public void setId(long rideId) {
        this.rideId = rideId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public LocalDateTime getDatetimeFrom() {
        return datetimeFrom;
    }

    public void setDatetimeFrom(LocalDateTime datetimeFrom) {
        this.datetimeFrom = datetimeFrom;
    }

    public LocalDateTime getDatetimeTo() {
        return datetimeTo;
    }

    public void setDatetimeTo(LocalDateTime datetimeTo) {
        this.datetimeTo = datetimeTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ride)) return false;
        Ride ride = (Ride) o;
        return rideId == ride.rideId &&
                getCarId() == ride.getCarId() &&
                getIdentityNumber().equals(ride.getIdentityNumber()) &&
                getDatetimeFrom().equals(ride.getDatetimeFrom()) &&
                getDatetimeTo().equals(ride.getDatetimeTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(rideId, getCarId(), getIdentityNumber(), getDatetimeFrom(), getDatetimeTo());
    }

    @Override
    public String toString() {
        return "Ride{" +
                "rideId=" + rideId +
                ", carId=" + carId +
                ", identityNumber='" + identityNumber + '\'' +
                ", datetimeFrom=" + datetimeFrom +
                ", datetimeTo=" + datetimeTo +
                '}';
    }
}
