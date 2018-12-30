package sk.pds.semestralka.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "COORDINATES")
public class Coordinates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long coordinatesId;
    private long rideId;
    private float latitude;
    private float longtitude;
    private float height;
    private LocalDateTime time;

    public Coordinates() {
    }

    public Coordinates(long rideId, float latitude, float longtitude, float height, LocalDateTime time) {
        this.rideId = rideId;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.height = height;
        this.time = time;
    }

    public long getId() {
        return coordinatesId;
    }

    public void setId(long coordinatesId) {
        this.coordinatesId = coordinatesId;
    }

    public long getRideId() {
        return rideId;
    }

    public void setRideId(long rideId) {
        this.rideId = rideId;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
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
        if (!(o instanceof Coordinates)) return false;
        Coordinates that = (Coordinates) o;
        return getId() == that.getId() &&
                getRideId() == that.getRideId() &&
                Float.compare(that.getLatitude(), getLatitude()) == 0 &&
                Float.compare(that.getLongtitude(), getLongtitude()) == 0 &&
                Float.compare(that.getHeight(), getHeight()) == 0 &&
                getTime().equals(that.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRideId(), getLatitude(), getLongtitude(), getHeight(), getTime());
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "id=" + coordinatesId +
                ", rideId=" + rideId +
                ", latitude=" + latitude +
                ", longtitude=" + longtitude +
                ", height=" + height +
                ", time=" + time +
                '}';
    }
}
