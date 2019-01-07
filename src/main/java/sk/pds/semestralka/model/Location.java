package sk.pds.semestralka.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

public class Location {
    private long locationId;
    private long rideId;
    private double latitude;
    private double longitude;
    private LocalDateTime time;

    public Location() {
    }

    public Location(long rideId, double latitude, double longitude, LocalDateTime time) {
        this.rideId = rideId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
    }

    public long getId() {
        return locationId;
    }

    public void setId(long locationId) {
        this.locationId = locationId;
    }

    public long getRideId() {
        return rideId;
    }

    public void setRideId(long rideId) {
        this.rideId = rideId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return locationId == location.locationId &&
                getRideId() == location.getRideId() &&
                Double.compare(location.getLatitude(), getLatitude()) == 0 &&
                Double.compare(location.getLongitude(), getLongitude()) == 0 &&
                getTime().equals(location.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, getRideId(), getLatitude(), getLongitude(), getTime());
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", rideId=" + rideId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", time=" + time +
                '}';
    }
}
