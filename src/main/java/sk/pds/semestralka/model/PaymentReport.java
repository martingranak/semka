package sk.pds.semestralka.model;

import java.util.Objects;

public class PaymentReport {
    private long rideId;
    private double value;
    private int count;
    private String description;

    public PaymentReport() {
    }

    public PaymentReport(long rideId, double value, int count, String description) {
        this.rideId = rideId;
        this.value = value;
        this.count = count;
        this.description = description;
    }

    public long getRideId() {
        return rideId;
    }

    public void setRideId(long rideId) {
        this.rideId = rideId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
        if (o == null || getClass() != o.getClass()) return false;
        PaymentReport that = (PaymentReport) o;
        return rideId == that.rideId &&
                Double.compare(that.value, value) == 0 &&
                count == that.count &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rideId, value, count, description);
    }

    @Override
    public String toString() {
        return "RideReport{" +
                "rideId=" + rideId +
                ", value=" + value +
                ", count=" + count +
                ", description='" + description + '\'' +
                '}';
    }
}
