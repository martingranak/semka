package sk.pds.semestralka.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

public class Location {
    private long locationId;
    private long rideId;
    private Coordinates coordinates;
    private LocalDateTime time;

    public Location() {
    }

    public Location(long rideId, Coordinates coordinates, LocalDateTime time) {
        this.rideId = rideId;
        this.coordinates = coordinates;
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
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
                getCoordinates().equals(location.getCoordinates()) &&
                getTime().equals(location.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, getRideId(), getCoordinates(), getTime());
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", rideId=" + rideId +
                ", coordinates=" + coordinates +
                ", time=" + time +
                '}';
    }
}
