package sk.pds.semestralka.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PAYMENT")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long rideId;
    private float value;
    private String description;

    public Payment() {
    }

    public Payment(long rideId, float value, String description) {
        this.rideId = rideId;
        this.value = value;
        this.description = description;
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

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return getId() == payment.getId() &&
                getRideId() == payment.getRideId() &&
                Float.compare(payment.getValue(), getValue()) == 0 &&
                getDescription().equals(payment.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRideId(), getValue(), getDescription());
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", rideId=" + rideId +
                ", value=" + value +
                ", description='" + description + '\'' +
                '}';
    }
}
