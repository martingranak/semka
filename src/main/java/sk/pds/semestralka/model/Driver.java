package sk.pds.semestralka.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DRIVER")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String identityNumber;

    public Driver() {
    }

    public Driver(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver driver = (Driver) o;
        return getId() == driver.getId() &&
                getIdentityNumber().equals(driver.getIdentityNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIdentityNumber());
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", identityNumber='" + identityNumber + '\'' +
                '}';
    }
}
