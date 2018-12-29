package sk.pds.semestralka.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "REZERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long rideId;
    private LocalDateTime rezervationTime;
    private LocalDateTime relevanceTime;

    public Reservation() {
    }

    public Reservation(long rideId, LocalDateTime rezervationTime, LocalDateTime relevanceTime) {
        this.rideId = rideId;
        this.rezervationTime = rezervationTime;
        this.relevanceTime = relevanceTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRideId() {
        return rideId;
    }

    public void setRideId(long rideId) {
        this.rideId = rideId;
    }

    public LocalDateTime getRezervationTime() {
        return rezervationTime;
    }

    public void setRezervationTime(LocalDateTime rezervationTime) {
        this.rezervationTime = rezervationTime;
    }

    public LocalDateTime getRelevanceTime() {
        return relevanceTime;
    }

    public void setRelevanceTime(LocalDateTime relevanceTime) {
        this.relevanceTime = relevanceTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return getId() == that.getId() &&
                getRideId() == that.getRideId() &&
                getRezervationTime().equals(that.getRezervationTime()) &&
                Objects.equals(getRelevanceTime(), that.getRelevanceTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRideId(), getRezervationTime(), getRelevanceTime());
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", rideId=" + rideId +
                ", rezervationTime=" + rezervationTime +
                ", relevanceTime=" + relevanceTime +
                '}';
    }
}
