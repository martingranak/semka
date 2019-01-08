package sk.pds.semestralka.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class Reservation {
    private long rideId;
    private LocalDateTime timeFrom;
    private LocalDateTime timeTo;
    private long carId;
    private String carName;
    private byte[] picture;
    private long identityNumber;
    private String name;

    public Reservation() {
    }

    public Reservation(long rideId, LocalDateTime timeFrom, LocalDateTime timeTo, long carId, String carName, byte[] picture, long identityNumber, String name) {
        this.rideId = rideId;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.carId = carId;
        this.carName = carName;
        this.picture = picture;
        this.identityNumber = identityNumber;
        this.name = name;
    }

    public long getRideId() {
        return rideId;
    }

    public void setRideId(long rideId) {
        this.rideId = rideId;
    }

    public LocalDateTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalDateTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalDateTime getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(LocalDateTime timeTo) {
        this.timeTo = timeTo;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public long getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(long identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return getRideId() == that.getRideId() &&
                getCarId() == that.getCarId() &&
                getIdentityNumber() == that.getIdentityNumber() &&
                getTimeFrom().equals(that.getTimeFrom()) &&
                getTimeTo().equals(that.getTimeTo()) &&
                getCarName().equals(that.getCarName()) &&
                Arrays.equals(getPicture(), that.getPicture()) &&
                getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getRideId(), getTimeFrom(), getTimeTo(), getCarId(), getCarName(), getIdentityNumber(), getName());
        result = 31 * result + Arrays.hashCode(getPicture());
        return result;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "rideId=" + rideId +
                ", timeFrom=" + timeFrom +
                ", timeTo=" + timeTo +
                ", carId=" + carId +
                ", carName='" + carName + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", identityNumber=" + identityNumber +
                ", name='" + name + '\'' +
                '}';
    }
}
