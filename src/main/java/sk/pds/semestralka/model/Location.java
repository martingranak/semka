package sk.pds.semestralka.model;

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

    public long getRideId() {
        return rideId;
    }

    public void setRideId(long rideId) {
        this.rideId = rideId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
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
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return locationId == location.locationId &&
                rideId == location.rideId &&
                Double.compare(location.latitude, latitude) == 0 &&
                Double.compare(location.longitude, longitude) == 0 &&
                Objects.equals(time, location.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(locationId, rideId, latitude, longitude, time);
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
